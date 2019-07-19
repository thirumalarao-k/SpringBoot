package com.hcl.msastudio.domain;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class ClassInfo implements Serializable {
	private String className;
	private String packageName;
	private String sterioType;
	private String beanType;
	private String noOfMethods;
	private String interfaces;
	private String superClass;
	private String loc;
	private String annotations;
	private String insVariables;
	private String importStmnts;
	private Set<MethodInfo> methods;
	private String sourceCode;
	private String projectId;
	private String entityData;
	private String tableNm;
	private String queries;
	private String sessionAttributes;
	private String proposedServices;

	public Set<MethodInfo> getMethods() {
		return methods;
	}

	public void setMethods(Set<MethodInfo> methods) {
		this.methods = methods;
	}

	public String getSterioType() {
		return sterioType;
	}

	public void setSterioType(String sterioType) {
		this.sterioType = sterioType;
	}

	public String getBeanType() {
		return beanType;
	}

	public void setBeanType(String beanType) {
		this.beanType = beanType;
	}

	public String getNoOfMethods() {
		return noOfMethods;
	}

	public void setNoOfMethods(String noOfMethods) {
		this.noOfMethods = noOfMethods;
	}

	public String getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(String interfaces) {
		this.interfaces = interfaces;
	}

	public String getSuperClass() {
		return superClass;
	}

	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getAnnotations() {
		return annotations;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}
	
	public String getInsVariables() {
		return insVariables;
	}

	public void setInsVariables(String insVariables) {
		this.insVariables = insVariables;
	}

	public String getImportStmnts() {
		return importStmnts;
	}

	public void setImportStmnts(String importStmnts) {
		this.importStmnts = importStmnts;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getEntityData() {
		return entityData;
	}

	public void setEntityData(String entityData) {
		this.entityData = entityData;
	}

	public String getTableNm() {
		return tableNm;
	}

	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
	}

	public String getQueries() {
		return queries;
	}

	public void setQueries(String queries) {
		this.queries = queries;
	}

	public String getSessionAttributes() {
		return sessionAttributes;
	}

	public void setSessionAttributes(String sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
	
	public String getProposedServices() {
		return proposedServices;
	}

	public void setProposedServices(String proposedServices) {
		this.proposedServices = proposedServices;
	}


}