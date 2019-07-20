package com.hcl.msa.parser;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hcl.msa.bean.ClassInfo;
import com.hcl.msa.bean.MethodCallHierarchy;
import com.hcl.msa.bean.MethodInfo;
import com.hcl.msa.util.PropertyFile;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.util.TablesNamesFinder;

public abstract class JavaVisitor extends ASTVisitor {
	private final static Logger LOGGER = LoggerFactory.getLogger(JavaVisitor.class.getName());
	protected static final String SESSION_ATTRIBUTES = "@SessionAttributes";
	protected static final String SERVICE = "@Service";
	protected static final String REPOSITORY = "@Repository";
	protected static final String TRANSACTIONAL = "@Transactional";
	protected static final String CONTROLLER = "@Controller";
	protected static final String REST_CONTROLLER = "@RestController";
	protected static final String STERIO_TYPE_OTHER = "Other";
	protected static final String STERIO_TYPE_SERVICE = "Service";
	protected static final String STERIO_TYPE_REPOSITORY = "Repository";
	protected static final String STERIO_TYPE_CONTROLLER = "Controller";
	protected static final String STERIO_TYPE_ACTION = "Action";
	protected static final String STERIO_TYPE_DISP_ACTION = "DispatchAction";
	protected static final String STERIO_TYPE_HB_ACTION = "org.hibernate";	
	protected static final String STERIO_TYPE_ACTION_FORWARD = "ActionForward";	
	protected static final String STERIO_TYPE_VULNERABILITY = "vulnerability";
	
	private Set<Object> annotations = new HashSet<Object>();
	private FieldDeclaration[] fieldDeclaration = null;
	private Map<String, String> declaredVariablesMap = new HashMap<String, String>();
	private Map<String, String> sessionVariablesMap = new HashMap<String, String>();
	private Map<String, String> locSessVariablesMap = new HashMap<String, String>();
	private Map<String, String> variableValueMap = new HashMap<String, String>();
	
	private TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();

	protected static final String INSERT = "INSERT";
	protected static final String PATH_CLASSINFO = "classinfo";
	
	protected ClassInfo cinfo = new ClassInfo();	
	protected CompilationUnit cu;
	protected List<String> classNames;
	protected Map<String,Object> xmlConfigInfo;
	protected boolean isHibernate = false;
	
	private String applicationTechnology;
	public String getApplicationTechnology() {
		return applicationTechnology;
	}

	public void setApplicationTechnology(String applicationTechnology) {
		this.applicationTechnology = applicationTechnology;
	}
	
	private List<String> excludedMethods= new ArrayList<String>();
	public JavaVisitor() {
		super();
		//excludedMethods.add("ejbCreate");
		excludedMethods.add("ejbRemove");
		excludedMethods.add("ejbPassivate");
		excludedMethods.add("ejbActivate");
		excludedMethods.add("addAttribute");
		excludedMethods.add("warn");
		excludedMethods.add("debug");
		excludedMethods.add("info");
		excludedMethods.add("set");
		excludedMethods.add("put");
		excludedMethods.add("parseInt");
		excludedMethods.add("parseDouble");
		excludedMethods.add("parseLang");
		excludedMethods.add("parseInt");
		excludedMethods.add("close");
		excludedMethods.add("open");
		excludedMethods.add("println");
		excludedMethods.add("findForward");
		
	}

	public JavaVisitor(boolean visitDocTags) {
		super(visitDocTags);
	}

	protected void parseClassSterioType(TypeDeclaration node) {
		for (Iterator<?> iterator = node.modifiers().iterator(); iterator.hasNext();) {
			try {
	
				Object object = iterator.next();
	
				if (object != null) {
					if (object.toString().equals(CONTROLLER) || object.toString().equals(REST_CONTROLLER)) {
						cinfo.setSterioType(STERIO_TYPE_CONTROLLER);
						break;
					} else if (object.toString().startsWith(REPOSITORY)
							|| object.toString().startsWith(TRANSACTIONAL)) {
						cinfo.setSterioType(STERIO_TYPE_REPOSITORY);
						break;
					} else if (object.toString().startsWith("@Entity")) {
						cinfo.setSterioType("Entity");
						break;
					} else if (object.toString().startsWith(SERVICE)) {
						cinfo.setSterioType(STERIO_TYPE_SERVICE);
						break;
					} else if (object.toString().startsWith("public")) {
						cinfo.setSterioType(STERIO_TYPE_OTHER);
						break;
					}
					if (object.toString().equals("CrossOrigin")) {
						cinfo.setSterioType(STERIO_TYPE_VULNERABILITY);
						break;
					}
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void parseClassModifiers(TypeDeclaration node) {
		//Get all class level annotations and its modifiers
		for (Iterator<?> iterator = node.modifiers().iterator(); iterator.hasNext();) {
			Object annotationObject = iterator.next();
			if (annotationObject != null && annotationObject.toString().startsWith("@")) {
				annotations.add(annotationObject.toString());
			}
			parseSessionVariables(annotationObject);
		}
	}

	private void parseSessionVariables(Object annotationObject) {
		// set the session variables from @SessionAttributes
		if (annotationObject != null && annotationObject.toString().startsWith(SESSION_ATTRIBUTES)) {
			String[] sessionVars;
			sessionVars = annotationObject.toString()
					.substring(annotationObject.toString().indexOf("(") + 1, annotationObject.toString().indexOf(")"))
					.replaceAll("[\"{}]", "").split(",");
			if (sessionVars.length > 0) {
				for (String sv : sessionVars) {
					sessionVariablesMap.put(sv, "");
				}
			}
		}
	}

	protected void parseClassInfo(TypeDeclaration node) throws JsonProcessingException {
		parseClassLevelVariables(node);
		MethodDeclaration[] methods = node.getMethods();
		cinfo.setSourceCode(node.getRoot().toString());
		cinfo.setNoOfMethods(Integer.toString(methods.length));
		ASTNode parent = node.getParent();
		for(Object obj:cu.imports()){
			String[] values = obj.toString().split("\\s");
			String impClass = values[values.length-1];
			//String impClass = val.substring(0, val.length());
			if(impClass.contains(STERIO_TYPE_HB_ACTION)){
				System.out.println("values:"+impClass);
				isHibernate = true;
				break;
			}			
		}
		if (!node.superInterfaceTypes().isEmpty()) {
			cinfo.setInterfaces(node.superInterfaceTypes().toString());
		}

		cinfo.setSuperClass(node.getSuperclassType() == null ? null : node.getSuperclassType().toString());
		String className = node.getName().toString();
		cinfo.setClassName(className);
		if (className.indexOf(STERIO_TYPE_CONTROLLER) > 0) {
			cinfo.setProposedServices(className.substring(0, className.indexOf(STERIO_TYPE_CONTROLLER)) + STERIO_TYPE_SERVICE);
		} else if (className.indexOf("Bean") > 0) {
			cinfo.setProposedServices(className.substring(0, className.indexOf("Bean")) + STERIO_TYPE_SERVICE);
		} else if (cinfo.getSterioType().equals(STERIO_TYPE_CONTROLLER)) {
			cinfo.setProposedServices(className + STERIO_TYPE_SERVICE);
		}else if(!Modifier.isAbstract(node.getModifiers()) && (className.indexOf(STERIO_TYPE_ACTION) > 0 || className.indexOf(STERIO_TYPE_DISP_ACTION) > 0)){
			//boolean status = Modifier.isAbstract(node.getModifiers());
			cinfo.setSterioType(STERIO_TYPE_CONTROLLER);
			cinfo.setProposedServices(className.substring(0, className.indexOf(STERIO_TYPE_ACTION)) + STERIO_TYPE_SERVICE);			
		}
		try {
			cinfo.setPackageName(
					parent.toString().substring(parent.toString().indexOf(" "), parent.toString().indexOf("\n")));
			cinfo.setAnnotations(annotations.toString());
			// Commented as the Entity info is being added at Method level
			// parseEntityAnnotation(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String parseSessionAttributes(Map<String, String> variableMap) {
		List<String> result = new ArrayList<>();
		String endResult = "";
		if(variableMap != null && !variableMap.isEmpty()) {
			for (Map.Entry<String, String> m : variableMap.entrySet()) {
				if(m.getValue().trim() != "") {
					String s = m.getValue()+" "+m.getKey();
					LOGGER.debug(s);
					result.add(s);
				}
			} 
			if(!result.isEmpty()){
				endResult = result.toString();
			}
			LOGGER.debug("Session Variables..."+endResult);
		}
		return endResult;
	}
	
	protected void parseJPARespository(Set methodCallHierarchy, MethodInfo mInfo, TypeDeclaration node) {
		List<Type> superInterfaces = node.superInterfaceTypes();
		for (Type intface : superInterfaces) {
			MethodCallHierarchy mch = new MethodCallHierarchy();
			String[] result1 = intface.toString().split("<");
			String intfaceNm = result1[0];
			if (intfaceNm.equals("Repository") || intfaceNm.equals("JpaRepository")||isHibernate) {
				cinfo.setSterioType(STERIO_TYPE_REPOSITORY);
				identifyProposedService(mch, mInfo);
				mch.setObjectRef(node.getName().toString());
				mch.setObjectRefDefineType(identifyClassDefType(node.getName().toString()));
				if(intfaceNm.equals("Repository") || intfaceNm.equals("JpaRepository")){
					mch.setTechnology("Data JPA");
				}else if(isHibernate){
					mch.setTechnology("Hibernate");
				}
				if(result1.length > 1){
					String[] result2 = result1[1].split(",");
					String entity = result2[0];
					mch.setTableNms(entity);
				}else if(isHibernate){
					String temp = mch.getProposedMicroService();
					String entity = temp.substring(0, temp.indexOf("Service"));
/*					//Need to Handle if class contains more than one entity types
					if(null!=entity&&!entity.equals(mInfo.getReturnType())){
						entity = entity +","+mInfo.getReturnType();
					}*/
					mch.setTableNms(entity);			
				}
				methodCallHierarchy.add(mch);
			}
		}
	}
	protected void parseHibernate(MethodInfo mInfo, TypeDeclaration node) {
		if(isHibernate){
				MethodCallHierarchy mch = new MethodCallHierarchy();
				cinfo.setSterioType(STERIO_TYPE_REPOSITORY);
				identifyProposedService(mch, mInfo);
				mch.setObjectRef(node.getName().toString());
				mch.setObjectRefDefineType(identifyClassDefType(node.getName().toString()));
				mch.setTechnology("Hibernate");
				//methodCallHierarchy.add(mch);
		}
	}
	
	protected void identifyProposedService(MethodCallHierarchy mch, MethodInfo mInfo) {
		boolean isBusinessCall = false;
		String methodSequence = mch.getMethodSequence();
		String proposedMicroService = "";
		if (methodSequence != null && (StringUtils.containsIgnoreCase(methodSequence, "Dao")
				|| StringUtils.containsIgnoreCase(methodSequence, "Repository")
				|| StringUtils.containsIgnoreCase(methodSequence, "service"))) {
			proposedMicroService = methodSequence.substring(0, methodSequence.indexOf("-"));
			if (proposedMicroService != null && !("null".equalsIgnoreCase(proposedMicroService))) {
				proposedMicroService = proposedMicroService.replaceFirst("Dao", "");
				proposedMicroService = proposedMicroService.replaceFirst("DAO", "");
				proposedMicroService = proposedMicroService.replaceFirst("DOA", "");
				proposedMicroService = proposedMicroService.replaceFirst("Repository", "");
				if (!StringUtils.endsWithIgnoreCase(proposedMicroService, "Service"))
					proposedMicroService = proposedMicroService + "Service";
				isBusinessCall = true;
			}

		}
		if (proposedMicroService.isEmpty()) {
			proposedMicroService = cinfo.getClassName();
			proposedMicroService = StringUtils.removeIgnoreCase(proposedMicroService, "dao");
			proposedMicroService = StringUtils.removeIgnoreCase(proposedMicroService, "impl");
			proposedMicroService = StringUtils.removeIgnoreCase(proposedMicroService, "Repository");
			proposedMicroService = StringUtils.removeIgnoreCase(proposedMicroService, "Controller");
			proposedMicroService = StringUtils.removeIgnoreCase(proposedMicroService, "Action");
			proposedMicroService = StringUtils.removeIgnoreCase(proposedMicroService, "Bean");
			if (!StringUtils.endsWithIgnoreCase(proposedMicroService, "Service"))
				proposedMicroService = proposedMicroService + "Service";
		}
		mch.setProposedMicroService(proposedMicroService);
		String componsatingService = mch.getMethodRef();
		if (componsatingService == null || componsatingService.isEmpty())
			componsatingService = mInfo.getMethodName();
		String lowerCaseMethodRef = componsatingService.toLowerCase();

		if (isBusinessCall
				&& (!(StringUtils.equalsIgnoreCase(lowerCaseMethodRef, "put")
						|| StringUtils.startsWith(lowerCaseMethodRef, "get")
						|| StringUtils.startsWith(lowerCaseMethodRef, "set")))
				&& (StringUtils.containsIgnoreCase(lowerCaseMethodRef, "add")
						|| StringUtils.containsIgnoreCase(lowerCaseMethodRef, "save")
						|| StringUtils.containsIgnoreCase(lowerCaseMethodRef, "update")
						|| StringUtils.containsIgnoreCase(lowerCaseMethodRef, "delete")
						|| StringUtils.containsIgnoreCase(lowerCaseMethodRef, "edit")
						|| StringUtils.containsIgnoreCase(lowerCaseMethodRef, "create")
						|| StringUtils.containsIgnoreCase(lowerCaseMethodRef, "insert"))) {
			componsatingService = "revert" + StringUtils.capitalize(componsatingService);
			mch.setCompensatingService(componsatingService);
		}

	}
	
	protected void parseMethodInfo1(TypeDeclaration node) throws JsonProcessingException {
		try {
			Set<MethodInfo> methodSet = new HashSet<>();
			MethodDeclaration[] methods = node.getMethods();
			//LOGGER.debug(strutsConfig);
	
			for (int i = 0; i < methods.length; i++) {
				MethodInfo mInfo = new MethodInfo();
				String methodName = methods[i].getName().toString();
				if(excludedMethods.contains(methodName)) {
					continue;
				}
				mInfo.setMethodName(methodName);
				Set<com.hcl.msa.bean.MethodCallHierarchy> methodCallHierarchy = new HashSet<>();
				parseHibernate(mInfo, node);
			}
			cinfo.setMethods(methodSet);
			cinfo.setSessionAttributes(parseSessionAttributes(sessionVariablesMap));
		}catch(Exception e){
			
		}
	}
	protected void parseMethodInfo(TypeDeclaration node) throws JsonProcessingException {
		try {
			Set<MethodInfo> methodSet = new HashSet<>();
			MethodDeclaration[] methods = node.getMethods();
			//LOGGER.debug(strutsConfig);
	
			for (int i = 0; i < methods.length; i++) {
				// MethodDeclaration md= methods[i];
				// md.getRoot().getParent();
				MethodInfo mInfo = new MethodInfo();
				Map<String, Object> locVariableMap = new HashMap<>();
				//reset the session variable for method level
				locSessVariablesMap = new HashMap<String, String>();
				String methodName = methods[i].getName().toString();
				if(excludedMethods.contains(methodName)) {
					continue;
				}
				mInfo.setMethodName(methodName);
				if (methods[i].getReturnType2() != null) {
					mInfo.setReturnType(methods[i].getReturnType2().toString());
				}	
				String className = node.getName().toString();
				if(className.indexOf(STERIO_TYPE_ACTION) > 0 && ((null!=mInfo.getReturnType() && !mInfo.getReturnType().equals(STERIO_TYPE_ACTION_FORWARD)))||(className.equals(methodName))) continue;				

				if (methods[i] != null) {
					if (methods[i].modifiers() != null) {
						StringBuffer methodLevelAnnoatations=new StringBuffer();
						for (Iterator iterator = methods[i].modifiers().iterator(); iterator.hasNext();) {
							Object obj = iterator.next();
							NormalAnnotation normalAnnotation = null;
							MarkerAnnotation markerAnnotation = null;
							SingleMemberAnnotation singleMemAnnotation = null;
							if (obj instanceof NormalAnnotation) {
								normalAnnotation = (NormalAnnotation) obj;
								// Setting the HTTP method Type
								if (normalAnnotation.getTypeName() != null)
									mInfo.setHttpMethod(normalAnnotation.getTypeName().toString());

								for (Iterator iterator2 = normalAnnotation.values().iterator(); iterator2.hasNext();) {
									MemberValuePair memberValuePair = (MemberValuePair) iterator2.next();
									mInfo.setMethodSignature(memberValuePair.getValue().toString());
									break;
								}
							}
							if (obj instanceof SingleMemberAnnotation) {
								singleMemAnnotation = (SingleMemberAnnotation) obj;
								mInfo.setMethodSignature(singleMemAnnotation.getValue().toString());

							}
							if (obj instanceof MarkerAnnotation) {
								markerAnnotation = (MarkerAnnotation) obj;
								if (markerAnnotation.getTypeName() != null) {
									// mInfo.setHttpMethod(markerAnnotation.getTypeName().toString());
								}
							}
							// Added below code to capture method level annotations
							if (obj != null && obj.toString().startsWith("@")) {
								methodLevelAnnoatations.append(obj.toString());
								LOGGER.debug("Method Level Annotations are :" + obj.toString());
							}
							
						}mInfo.setAnnotations(methodLevelAnnoatations.toString());
						}
					
					List<?> params = methods[i].parameters();
					if (params != null && !params.isEmpty()) {
						mInfo.setNoOfParams(Integer.toString(params.size()));
						//update local variables from method params
						for(Object param : params) {
							String s= param.toString().trim();
							String[] arg=s.split("\\s+");
							if(arg.length >= 2) {
								locVariableMap.put(arg[arg.length-1], arg[arg.length-2]);
								//get the session variable using sessionAttribute in method params
								if(arg[0].startsWith("@SessionAttribute")) {
									 String sessVar = arg[0].substring(arg[0].indexOf("("), arg[0].indexOf(")")).replaceAll("[\"']", "");
									 locSessVariablesMap.put(sessVar, arg[arg.length-2]);
								}
							}
						}
					}


					if (!methods[i].parameters().isEmpty()) {
						mInfo.setMethodParams(methods[i].parameters().toString());
						LOGGER.debug("Method params..."+methods[i].parameters().toString());
					}
					if (methods[i].getBody() != null) {
						mInfo.setMethodBody(getMethodSource(methods[i]));
						//Parse all statements if any inside a method
						if(methods[i].getBody().statements() != null && !methods[i].getBody().statements().isEmpty()) {
							mInfo.setLoc(Integer.toString(methods[i].getBody().statements().size()));
							Set<com.hcl.msa.bean.MethodCallHierarchy> methodCallHierarchy = new HashSet<>();
							setMethodCallHierarchy(methodCallHierarchy, locVariableMap, mInfo,
									methods[i].getBody(), node);														
						}
					}else if(node.isInterface()) {
						Set<com.hcl.msa.bean.MethodCallHierarchy> methodCallHierarchy = new HashSet<>();
						setMethodCallHierarchy(methodCallHierarchy, locVariableMap, mInfo,methods[i].getBody(), node);
					}
					
				}

				mInfo.setSessionAttributes(parseSessionAttributes(locSessVariablesMap));
				methodSet.add(mInfo);
			}
			cinfo.setMethods(methodSet);
			cinfo.setSessionAttributes(parseSessionAttributes(sessionVariablesMap));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void setMethodCallHierarchy(Set methodCallHierarchySet, Map variableMap, MethodInfo mInfo, Block block, TypeDeclaration node) {
		boolean txHB=false;
		try {
			String temp;
			declaredVariablesMap.putAll(variableMap);
		
			
			if (node.isInterface()||isHibernate) {				
				parseJPARespository(methodCallHierarchySet, mInfo, node);
			}
			
			//Added to skip interfaces to go through the below logic
			
			if(!node.isInterface()) {
			//Added to skip other than Hibernate
			if(isHibernate){
				
			}else{

			//Iterate over all statements inside a block of method
			for (Iterator iterator = block.statements().iterator(); iterator.hasNext();) {
				MethodCallHierarchy mch = new MethodCallHierarchy();
				Object statementObj = iterator.next();
				LOGGER.debug("TESTING " + statementObj.getClass() + "   " + statementObj.toString());
				/*
				IfStatement
				ForStatement
				WhileStatement
				DoStatement
				TryStatement
				SwitchStatement
				SynchronizedStatement
				EnhancedForStatement
				ReturnStatement
				VariableDeclarationStatement
				ExpressionStatement
				.
				.
				.
				*/
				if (statementObj instanceof TryStatement) {
					TryStatement vds = (TryStatement) statementObj;
					setMethodCallHierarchy(methodCallHierarchySet, variableMap, mInfo, vds.getBody(),node);
					
				}
				
				if (statementObj instanceof IfStatement) {
					IfStatement vds = (IfStatement) statementObj;
					Block blck = null;
					if(vds.getThenStatement() instanceof Block) {
						blck = (Block)vds.getThenStatement();
					}else if(vds.getElseStatement() instanceof Block) {
						blck = (Block)vds.getElseStatement();
					}
					if(blck != null) {
						setMethodCallHierarchy(methodCallHierarchySet, variableMap, mInfo, blck ,node);
						
					}
				}
				
				if(statementObj instanceof SynchronizedStatement) {
					SynchronizedStatement syncstmt = (SynchronizedStatement)statementObj;
					setMethodCallHierarchy(methodCallHierarchySet, variableMap, mInfo, syncstmt.getBody(),node);
					
				}
				
				if (statementObj instanceof EnhancedForStatement || statementObj instanceof ForStatement
						|| statementObj instanceof WhileStatement || statementObj instanceof DoStatement 
							|| statementObj instanceof SwitchStatement) {
					Block body;
					if(statementObj instanceof EnhancedForStatement) {
						EnhancedForStatement enhForstmt = (EnhancedForStatement) statementObj;
						body = (Block) enhForstmt.getBody();
					}else if(statementObj instanceof ForStatement){
						ForStatement forstmt = (ForStatement) statementObj;
						body = (Block) forstmt.getBody();
					}else if(statementObj instanceof WhileStatement) {
						WhileStatement whlestmt = (WhileStatement) statementObj;
						body = (Block) whlestmt.getBody();
					}else if(statementObj instanceof DoStatement) {
						DoStatement dostmt = (DoStatement) statementObj;
						body = (Block) dostmt.getBody();
					}else {//SwitchStatement
						SwitchStatement swtstmt = (SwitchStatement)statementObj;
						body = (Block) swtstmt.statements();
					}
	
					List<?> statements = body.statements();
					Statement statement = (Statement) statements.get(0);
					if (statement instanceof ExpressionStatement) {
						ExpressionStatement expr = (ExpressionStatement) statement;
						if (expr.getExpression() != null && expr.getExpression() instanceof MethodInvocation) {
							MethodInvocation inv = (MethodInvocation) expr.getExpression();
							if (inv.getExpression() != null
									&& declaredVariablesMap.get(inv.getExpression().toString()) != null) {
								parseMethodCallHierarchy(node, mch, inv,methodCallHierarchySet,mInfo,txHB);
								
							}
						}
					}
				}

				if (statementObj instanceof CatchClause) {
					LOGGER.debug("Calling Catch Class");
					CatchClause cs = (CatchClause) statementObj;
					
				}

				if (statementObj instanceof ReturnStatement) {
					ReturnStatement rtStmt = (ReturnStatement) statementObj;
					if (rtStmt.getExpression() instanceof MethodInvocation) {
						MethodInvocation expr = (MethodInvocation) rtStmt.getExpression();
						parseMethodCallHierarchy(node, mch, expr,methodCallHierarchySet,mInfo,txHB);
					}
				}
				
				if (statementObj instanceof VariableDeclarationStatement) {
					VariableDeclarationStatement vds = (VariableDeclarationStatement) statementObj;
					if (vds.fragments() != null) {
						temp = vds.fragments().get(0).toString();
						for (int i = 0; i < vds.fragments().size(); ++i) {
							VariableDeclarationFragment frag = (VariableDeclarationFragment) vds.fragments().get(i);
							if (vds.getType() instanceof SimpleType) {
								declaredVariablesMap.put(frag.getName().toString(), vds.getType().toString());
								if(frag.getInitializer()!=null) {
									variableValueMap.put(frag.getName().toString(), frag.getInitializer().toString());
									}
							}
							
							if (frag.getInitializer() instanceof MethodInvocation) {
								MethodInvocation inv = (MethodInvocation) frag.getInitializer();
								parseMethodCallHierarchy(node, mch, inv,methodCallHierarchySet,mInfo,txHB);
							
							}
						}

					}
				}

				if (statementObj instanceof ExpressionStatement) {
					ExpressionStatement expStmt = (ExpressionStatement) statementObj;
					// Added for capturing assignment expressions
					if (expStmt.getExpression() instanceof Assignment) {
						Assignment asg = (Assignment) expStmt.getExpression();
						if (asg.getRightHandSide() instanceof MethodInvocation) {
						
							MethodInvocation expr = (MethodInvocation) asg.getRightHandSide();
							LOGGER.debug("Expression at right hand side:"+asg.getRightHandSide().toString());
							parseMethodCallHierarchy(node, mch, expr,methodCallHierarchySet,mInfo,txHB);
						}
					}
				//End of handling assignment expressions.	
					if (expStmt.getExpression() instanceof MethodInvocation) {
						MethodInvocation expr = (MethodInvocation) expStmt.getExpression();
						//LOGGER.debug("ExpressionStatement..." + expr.getNodeType() + " Method name..."+ expr.getName()+" Method reference..."+expr.getExpression());
						
						List<?> arguments = expr.arguments();
						//LOGGER.debug("ExpressionStatement Arguments..." + arguments);

						for (int i = 0; i < arguments.size(); i++) {
							if (arguments.get(i) instanceof MethodInvocation) {
								MethodInvocation arg = (MethodInvocation) arguments.get(i);
								parseMethodCallHierarchy(node, mch, arg,methodCallHierarchySet,mInfo,txHB);
							}
						}
/*
					  if (expr.getExpression() != null && !(expr.getExpression().toString().contains("logger"))&&!(expr.getExpression().toString().contains("log"))) {
							if (expr.getName() != null && !excludedMethods.contains(expr.getName().toString())) {
								mch.setObjectRef(declaredVariablesMap.get(expr.getExpression().toString()));
								mch.setObjectRefDefineType(identifyClassDefType(declaredVariablesMap.get(expr.getExpression().toString())));
								mch.setMethodRef(expr.getName().toString());
								mch.setMethodSequence(declaredVariablesMap.get(expr.getExpression().toString()) + "->"
										+ expr.getName().toString());
								if("beginTransaction".equals(expr.getName().toString())){
									txHB = true;
								}
							} else {
								mch.setObjectRef(node.getName().toString());
								mch.setObjectRefDefineType(identifyClassDefType(node.getName().toString()));
								mch.setMethodSequence("");

							}
							if (mch.getObjectRef() != null) {
								mch.setIntegrationComp(mch.getObjectRef());
								mch.setTechnology(PropertyFile.getInstance().getTechnology(mch.getObjectRef()));
							}
							identifyProposedService(mch,mInfo);
							methodCallHierarchySet.add(mch);
						}*/
						
						if (expr.getExpression() != null && arguments!=null && arguments.size()!=0 && arguments.size() <= 2) {// To check session variables
							String temp1 = arguments.get(0).toString().replaceAll("[\"']", "");
							if (( ( "addObject".equals(expr.getName().toString()) || "addAttribute".equals(expr.getName().toString()) ) && sessionVariablesMap.containsKey(arguments.get(0).toString().replaceAll("[\"']", ""))) 
									|| ( ("setAttribute".equals(expr.getName().toString()) || "getAttribute".equals(expr.getName().toString()) ) && "HttpSession".equals(declaredVariablesMap.get(expr.getExpression().toString()))) ) {
								String varName = arguments.get(0).toString().replaceAll("[\"']", "");
								String varType;
								if(arguments.size() == 1) {
									varType = declaredVariablesMap.get(varName);
								}else {
									//remove method invocation if any
									String[] args = arguments.get(1).toString().split("\\.") ;
									if(null!=declaredVariablesMap.get(args[0])){
										varType = declaredVariablesMap.get(args[0]);
									}else{
										//varType = args[0];
										varType = arguments.get(1).toString();
									}
								}
								sessionVariablesMap.put(varName, varType);
								locSessVariablesMap.put(varName, varType);
							}

						}
					}
				}
			}
			
			}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		mInfo.setMethodCallHierarchy(methodCallHierarchySet);
		if(txHB){
			mInfo.setAnnotations("Transactional");
		}
	}

	private void parseMethodCallHierarchy(TypeDeclaration node, MethodCallHierarchy mch, MethodInvocation methodInv, Set methodCallHierarchySet, MethodInfo mInfo,boolean txHB) {
		String methodInvName=methodInv.getName().toString();
		boolean validMethodInv =true;
		
			if(excludedMethods.contains(methodInvName)) {
				validMethodInv=false;
			}

			if(validMethodInv) {
				mch.setMethodRef(methodInvName);
				StringBuilder methodParams = parseRefMethodParams(methodInv);
				mch.setMethodRefParams(methodParams.toString());
				List minvarg=methodInv.arguments();
				for (Iterator iterator = minvarg.iterator(); iterator.hasNext();) {
					
					Object object = iterator.next();
					if(object instanceof MethodInvocation ) {
						MethodInvocation minv=(MethodInvocation)object;
					parseMethodCallHierarchy(node, mch, minv, methodCallHierarchySet, mInfo, txHB);
					}
				}
		
				if (methodInv.getExpression() != null) {
					String dummy = "";
					if(declaredVariablesMap.get(methodInv.getExpression().toString())!=null){
						dummy = declaredVariablesMap.get(methodInv.getExpression().toString());
					}else{
						dummy = methodInv.getExpression().toString();
					}
					dummy=dummy.replace("this.", "");
					
					mch.setObjectRef(dummy);
					mch.setObjectRefDefineType(identifyClassDefType(dummy));
					if(dummy==null || dummy.equalsIgnoreCase("null"))
						mch.setMethodSequence(methodInvName);
					else
					mch.setMethodSequence(dummy+ "->" + methodInvName);
					
					mch.setIntegrationComp(dummy);
					if("beginTransaction".equals(methodInv.getExpression().toString())){
						txHB = true;
					}
		
				} else {
					if(!("null".equals(methodInvName.toString()) || excludedMethods.contains(methodInvName))) {
					mch.setObjectRef(node.getName().toString());
					mch.setObjectRefDefineType(identifyClassDefType(node.getName().toString()));
					if (methodInv.getName() != null)
						mch.setMethodSequence("->" + methodInvName);
					mch.setIntegrationComp("");
					}
		
				}
				if (mch.getObjectRef() != null) {
					mch.setIntegrationComp(mch.getObjectRef());
					mch.setTechnology(PropertyFile.getInstance().getTechnology(mch.getObjectRef()));
				}
			if(mch.getMethodRef()!=null && !"".equals(mch.getMethodRef().toString())) {
					parseSQLQuery(mch, methodInv);				
					identifyProposedService(mch,mInfo);
					methodCallHierarchySet.add(mch);
				}
			}
	}

	private void parseSQLQuery(MethodCallHierarchy mch, MethodInvocation expr)  {
		if(mch.getMethodRef()!=null&&(mch.getMethodRef().equals("createStatement")||mch.getMethodRef().equals("prepareCall")||mch.getMethodRef().equals("prepareStatement")||mch.getMethodRef().equals("query"))){
			try {
				List<?> arguments = expr.arguments();
				for (int i = 0; i < arguments.size(); i++) {
					LOGGER.debug("Argument Key:" + arguments.get(i) + " Method variable list size:"
							+ variableValueMap.size() + "All Keys:" + variableValueMap.keySet() + "All Values:"
							+ variableValueMap.values());
					LOGGER.debug("Argument Value:" + variableValueMap.get(arguments.get(i).toString()));
					String query=(String)variableValueMap.get(arguments.get(i).toString());
					if(StringUtils.containsIgnoreCase(query, "from") || StringUtils.containsIgnoreCase(query, "table")|| StringUtils.containsIgnoreCase(query, "insert")){
						net.sf.jsqlparser.statement.Statement s = CCJSqlParserUtil.parse(
								query.replaceAll("[\"+']", ""));

					List<?> tableList = tablesNamesFinder.getTableList(s);
					LOGGER.debug("Table List Size:" + tableList.size() + "Zero position element:" + tableList.get(0));
					String tableNm="";
					for (Iterator<?> itr = tableList.iterator(); itr.hasNext();) {
						tableNm = tableNm+(String) itr.next()+"#";
					}
					mch.setTableNms(tableNm);
						mch.setTechnology(PropertyFile.getInstance().getTechnology(mch.getMethodRef()));
				}
				}
			} catch (Throwable e) {
				LOGGER.debug("parseSQLQuery parser error :"+ e.getMessage());
			}
		}
	}

	private StringBuilder parseRefMethodParams(MethodInvocation arg) {
		StringBuilder methodParams = new StringBuilder();
		int last=0;
		for (Object object : arg.arguments()) {
			if(null != declaredVariablesMap.get(object.toString()) || "null".equals(declaredVariablesMap.get(object.toString()))) {
				methodParams.append(declaredVariablesMap.get(object.toString()))
				.append(" ").append(object.toString());
			}else {
				methodParams.append(object.toString());
			}
			if(last++ != arg.arguments().size() - 1) {
				methodParams.append(",");
			}
		
		}
		return methodParams;
	}

	private void parseClassLevelVariables(TypeDeclaration node) {
		fieldDeclaration = node.getFields();
		StringBuffer sb = new StringBuffer();
		String objectReference = null;
		//Fetch all the variable name and its type (Global variables in the node(class))
		for (int i = 0; i < fieldDeclaration.length; i++) {
			FieldDeclaration fd = (FieldDeclaration) fieldDeclaration[i];
			Object fieldDecStmt = fd.fragments().get(0);
			if (fieldDecStmt instanceof VariableDeclarationFragment) {
				VariableDeclarationFragment vd = (VariableDeclarationFragment) fieldDecStmt;
				objectReference = vd.getName().toString();
				sb.append(fd.getType().toString()).append(" ").append(objectReference);
				sb.append(",");
				if (!declaredVariablesMap.containsKey(objectReference)) {
					declaredVariablesMap.put(objectReference, fd.getType().toString());
				}
			}
		}
		cinfo.setInsVariables(sb.toString());
		System.out.println(cinfo);
	}
	
	private String getMethodSource(MethodDeclaration method) {
		StringBuilder methodSrc = new StringBuilder();
		if(method != null) {
			methodSrc.append(method.modifiers().toString().replaceAll("[\\[\\],]", " "))
			.append(method.getReturnType2()).append(" ")
			.append(method.getName()).append("( ").append(method.parameters().toString().replaceAll("[\\[\\]]", "")).append(" )")
			.append(method.getBody().toString());
		}
		return methodSrc.toString();
	}
	
	private String identifyClassDefType(String className) {
		if(classNames != null && !classNames.isEmpty()) {
			if(className != null && classNames.contains(className)) {
				return "user_defined";
			}else if(className != null){
				return "pre_defined";
			}else {
				return null;
			}
		}
		return null;
	}
	
	// Not required as of now as the Entity/Table info is parsed at method level
	@SuppressWarnings("unused")
	private void parseEntityAnnotation(TypeDeclaration node) {
		// Commenting below code to capture entity/table information at the method level
		
		LOGGER.debug(node.modifiers().toString());
		if (node.modifiers().toString().contains("@Entity")) {
			if (node.modifiers() != null) {
				for (Iterator<?> iterator = node.modifiers().iterator(); iterator.hasNext();) {
					Object obj = iterator.next();
					NormalAnnotation normalAnnotation = null;
					if (obj instanceof NormalAnnotation) {
						normalAnnotation = (NormalAnnotation) obj;
						for (Iterator<?> iterator2 = normalAnnotation.values().iterator(); iterator2.hasNext();) {
							MemberValuePair memberValuePair = (MemberValuePair) iterator2.next();
							cinfo.setTableNm(memberValuePair.getValue().toString());
						}
					}
				}
			}
		}
	}

}