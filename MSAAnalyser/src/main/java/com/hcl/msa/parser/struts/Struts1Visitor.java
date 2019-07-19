package com.hcl.msa.parser.struts;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.msa.bean.MethodInfo;
import com.hcl.msa.dao.MSARestService;
import com.hcl.msa.parser.JavaVisitor;
import com.hcl.msa.parser.xml.struts.struts13.jaxbmodel.Action;
import com.hcl.msa.parser.xml.struts.struts13.jaxbmodel.StrutsConfig;

import net.sf.jsqlparser.util.TablesNamesFinder;

public class Struts1Visitor extends JavaVisitor {
	private final static Logger LOGGER = LoggerFactory.getLogger(Struts1Visitor.class.getName());
	private String projectId;
	
	TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();

/*	public Struts1Visitor(CompilationUnit cu, String projectId) {
		LOGGER.debug("Calling Struts1Visitor");
		this.cu = cu;
		this.projectId = projectId;
		cinfo.setProjectId(projectId);
	}*/
	public Struts1Visitor(CompilationUnit cu, String projectId, List<String> classNameList,Map<String,Object> xmlConfigInfo) {
		super();
		LOGGER.debug("Calling Struts1Visitor");
		this.cu = cu;
		this.projectId = projectId;
		this.classNames = classNameList;
		this.xmlConfigInfo = xmlConfigInfo;
		cinfo.setProjectId(projectId);
	}

	public boolean visit(TypeDeclaration node) {
		LOGGER.debug("Struts1Visitor : Calling visit method for:"+node.getName().toString());
		try {
			setApplicationTechnology("Struts1");
			parseClassModifiers(node);
			parseClassSterioType(node);
			parseClassInfo(node);
			parseMethodInfo(node);
			
			specificURI(node);
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

	private void specificURI(TypeDeclaration node) {
		if (null != xmlConfigInfo && xmlConfigInfo.containsKey("strutsConfig")) {
			StrutsConfig strutsConfig = (StrutsConfig) xmlConfigInfo.get("strutsConfig");
			List<Action> actions = strutsConfig.getActionMappings().getAction();
			if (cinfo.getClassName().indexOf(STERIO_TYPE_ACTION) > 0) {
				for (Action act : actions) {
					String[] values = act.getType().split("\\.");
					if (values[values.length - 1].equals(cinfo.getClassName())) {
						int size = cinfo.getMethods().size();
						for (MethodInfo min : cinfo.getMethods()) {
							String path = null;
							if (size > 1 && null != act.getParameter()) {
								path = act.getPath() + ".do?" + act.getParameter() + "=" + min.getMethodName();
							} else {
								path = act.getPath() + ".do";
							}
							min.setMethodSignature(path);
						}
						break;
					}
				}
			}
		}
	}
	

}
