package com.hcl.msa.parser.ejb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.msa.dao.MSARestService;
import com.hcl.msa.parser.JavaVisitor;
import com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.EjbJar;
import com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Entity;
import com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.MessageDriven;
import com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Session;

import net.sf.jsqlparser.util.TablesNamesFinder;

public class EJBVisitor extends JavaVisitor {
	private final static Logger LOGGER = LoggerFactory.getLogger(EJBVisitor.class.getName());
	
	private static final String SESSIONBEAN_STATEFUL = "@Stateful";
	private static final String SESSIONBEAN_STATELESS = "@Stateless";
	private static final String SESSIONBEAN_SINGLETON = "@Singleton";
	private static final String ENTITYBEAN = "@Entity";
	private static final String MESSAGEDRIVEN = "@MessageDriven";
	private static final String TRANSACTION = "@TransactionManagement";
	private static final String STERIO_TYPE_SESSIONBEAN = "sessionbean";
	private static final String STERIO_TYPE_ENTITYBEAN = "entitybean";
	private static final String STERIO_TYPE_MESSAGEDRIVEN = "messagedrivenbean";
	private static final String SESSIONBEAN_BEAN_TYPE_STATEFUL = "stateful";
	private static final String SESSIONBEAN_BEAN_TYPE_STATELESS = "stateless";
	private static final String SESSIONBEAN_BEAN_TYPE_SINGLETON = "singleton";
	private static final String ENTITYBEAN_BEAN_TYPE_BEANMANAGED = "bean";
	private static final String ENTITYBEAN_BEAN_TYPE_CONTAINERMANAGED = "container";
	private static final String TRANSACTION_BEAN_TYPE_BEANMANAGED = "bean";
	private static final String TRANSACTION_BEAN_TYPE_CONTAINERMANAGED = "container";
	
	
	private String projectId;
	TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();

	public EJBVisitor(CompilationUnit cu, String projectId, List<String> classNameList,Map<String,Object> xmlConfigInfo) {
		super();
		LOGGER.debug("Calling EJB1Visitor");
		
		this.cu = cu;
		this.projectId = projectId;
		this.classNames = classNameList;
		this.xmlConfigInfo = xmlConfigInfo;
		cinfo.setProjectId(projectId);
	}

	public boolean visit(TypeDeclaration node) {
		LOGGER.debug("EJBVisitor : Calling visit method for:"+node.getName().toString());
		try {
			setApplicationTechnology("EJB");
			parseClassModifiers(node);
			parseClassSterioType(node);
			parseClassInfo(node);
			parseMethodInfo(node);
			
			System.out.println(cinfo);
			//merge all xml mappings if any
			mergeXMLConfigInfoWithClassInfo(xmlConfigInfo);
			String locStr=cu.getLineNumber(cu.toString().lastIndexOf("}"))+"";
			if(locStr!=null && !locStr.equals("-1"))
			cinfo.setLoc(locStr);
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(cinfo);
			
			// Save all infos like class, method and methods' call hierarchy
			MSARestService restSevice = new MSARestService();
			restSevice.msaRestServiceCall(jsonInString, "INSERT", PATH_CLASSINFO);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return true; // do continue
	}
	
	@Override
	protected void parseClassSterioType(TypeDeclaration node) {
		
		//for ejb3.x - Annotation based.
		for (Iterator<?> iterator = node.modifiers().iterator(); iterator.hasNext();) {
			try {
				Object object = iterator.next();
	
				if (object != null) {
					if (object.toString().equals(SESSIONBEAN_STATEFUL)) {
						cinfo.setSterioType(STERIO_TYPE_SESSIONBEAN);
						cinfo.setBeanType(SESSIONBEAN_BEAN_TYPE_STATEFUL);
					} else if (object.toString().startsWith(SESSIONBEAN_STATELESS)) {
						cinfo.setSterioType(STERIO_TYPE_SESSIONBEAN);
						cinfo.setBeanType(SESSIONBEAN_BEAN_TYPE_STATELESS);
					}  else if (object.toString().startsWith(SESSIONBEAN_SINGLETON)) {
						cinfo.setSterioType(STERIO_TYPE_SESSIONBEAN);
						cinfo.setBeanType(SESSIONBEAN_BEAN_TYPE_SINGLETON);
					} else if (object.toString().startsWith(ENTITYBEAN)) {
						cinfo.setSterioType(STERIO_TYPE_ENTITYBEAN);
					} else if (object.toString().startsWith(MESSAGEDRIVEN)) {
						cinfo.setSterioType(STERIO_TYPE_MESSAGEDRIVEN);
					} else if (object.toString().startsWith(TRANSACTION)) {
						if(object.toString().toLowerCase().contains("bean")) {
							//update bean type with transaction info as bean managed
							if(null != cinfo.getBeanType())
								cinfo.setBeanType(cinfo.getBeanType()+"_"+TRANSACTION_BEAN_TYPE_BEANMANAGED);
							else
								cinfo.setBeanType(TRANSACTION_BEAN_TYPE_BEANMANAGED);
						}else {//container managed
							if(null != cinfo.getBeanType())
								cinfo.setBeanType(cinfo.getBeanType()+"_"+TRANSACTION_BEAN_TYPE_CONTAINERMANAGED);
							else
								cinfo.setBeanType(TRANSACTION_BEAN_TYPE_CONTAINERMANAGED);
						}
					} else if (object.toString().startsWith("public")) {
						if(null == cinfo.getSterioType()) { 
							cinfo.setSterioType(STERIO_TYPE_OTHER);
						}
					} 
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//upto ejb2.x
		if (!node.superInterfaceTypes().isEmpty()) {
			String superInterfaces=node.superInterfaceTypes().toString();
			if(superInterfaces.contains("SessionBean")) {
				cinfo.setSterioType(STERIO_TYPE_SESSIONBEAN);	
			}else if(superInterfaces.contains("EntityBean")) {
				cinfo.setSterioType(STERIO_TYPE_ENTITYBEAN);	
			}else if(superInterfaces.contains("MessageDrivenBean")) {
				cinfo.setSterioType(STERIO_TYPE_MESSAGEDRIVEN);	
			}else {
				cinfo.setSterioType(STERIO_TYPE_OTHER);
			}
		}
	}
	
	private void mergeXMLConfigInfoWithClassInfo(Map<String,Object> xmlConfigInfo) {
		if(null != xmlConfigInfo && xmlConfigInfo.containsKey("ejbjarConfig")) {
			Object ejbjarInfoObj = xmlConfigInfo.get("ejbjarConfig");
			//get the EjbJar instance
			List<Object> ejbs = new ArrayList<>() ;
			if(ejbjarInfoObj instanceof com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.EjbJar) {
				com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.EjbJar ejbjarInfo = (com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.EjbJar)ejbjarInfoObj;
				ejbs = ejbjarInfo.getEnterpriseBeans().getSessionOrEntityOrMessageDriven();
			}else if(ejbjarInfoObj instanceof com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EjbJar) {
				com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EjbJar ejbjarInfo = (com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EjbJar)ejbjarInfoObj;
				ejbs = ejbjarInfo.getEnterpriseBeans().getSessionOrEntityOrMessageDriven();
			}
						 
			for (Object obj : ejbs) {
				String beanType = "";
				String ejbName = null;
				String ejbClass = null;
				String ejbTransType = null;
								
				if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.SessionBean 
						|| obj instanceof com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Session ) {
					if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.SessionBean) {
						com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.SessionBean sessBean = (com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.SessionBean)obj;
						beanType =sessBean.getSessionType().getValue();
						ejbTransType = sessBean.getTransactionType().getValue();
						ejbName = sessBean.getEjbName().getValue();
						ejbClass = sessBean.getEjbClass().getValue();
					}else if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Session) {
						com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Session sessBean = (com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Session)obj;
						beanType =sessBean.getSessionType().getvalue();
						ejbTransType = sessBean.getTransactionType().getvalue();
						ejbName = sessBean.getEjbName().getvalue();
						ejbClass = sessBean.getEjbClass().getvalue();
					}
					
				}else if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EntityBean 
							|| obj instanceof com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Entity ) {
					if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Entity) {
						com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Entity entBean = (com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.Entity)obj;
						beanType = entBean.getPersistenceType().getvalue();
						if(null != entBean.getEjbName().toString()) {
							cinfo.setTableNm(entBean.getEjbName().getvalue());
							cinfo.setQueries(entBean.getQuery().toString());
						}
						ejbName = entBean.getEjbName().getvalue();
						ejbClass = entBean.getEjbClass().getvalue();
					}else if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EntityBean) {
						com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EntityBean entBean = (com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EntityBean)obj;
						beanType = entBean.getPersistenceType().getValue();
						if(null != entBean.getEjbName().toString()) {
							cinfo.setTableNm(entBean.getEjbName().getValue());
							cinfo.setQueries(entBean.getQuery().toString());
						}
						ejbName = entBean.getEjbName().getValue();
						ejbClass = entBean.getEjbClass().getValue();
					}
				}else if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.MessageDrivenBean 
							|| obj instanceof com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.MessageDriven ) {
					if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.MessageDriven) {
						com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.MessageDriven mdBean= (com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.MessageDriven)obj;
						ejbName = mdBean.getEjbName().getvalue();
						beanType = mdBean.getTransactionType().getvalue();
						ejbClass = mdBean.getEjbClass().getvalue();
					}else if(obj instanceof com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.MessageDrivenBean) {
						com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.MessageDrivenBean mdBean= (com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.MessageDrivenBean)obj;
						ejbName = mdBean.getEjbName().getValue();
						beanType = mdBean.getTransactionType().getValue();
						ejbClass = mdBean.getEjbClass().getValue();
					}
					
				}
				
				if(null != ejbClass  && cinfo.getClassName().equals(ejbClass.substring(ejbClass.lastIndexOf('.')+1, ejbClass.length()))) {
					cinfo.setBeanType(beanType.toLowerCase());
					if(null != cinfo.getBeanType() && (cinfo.getBeanType().contains("bean") || cinfo.getBeanType().contains("container"))){
						cinfo.setAnnotations("transaction");
					}
				}
			}
		}
	}

}
