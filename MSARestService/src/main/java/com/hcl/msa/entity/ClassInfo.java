package com.hcl.msa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_INFO")
public class ClassInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_Id")
	private int id;

	@Column(name = "class_name")
	private String className;
	@Column(name = "package_name", length = 1000)
	private String packageName;
	@Column(name = "sterio_type", length = 255)
	private String sterioType;
	@Column(name = "bean_type", length = 255)
	private String beanType;
	@Column(name = "no_of_methods")
	private String noOfMethods;
	@Column(name = "interfaces", length = 1000)
	private String interfaces;
	@Column(name = "super_class", length = 1000)
	private String superClass;
	@Column(name = "loc")
	private String loc;
	@Column(name = "annotations")
	private String annotations;
	@Column(name = "instance_var", length = 2000)
	private String insVariables;
	@Column(name = "source_code", length = 45000)
	private String sourceCode;
	@Column(name = "table_nm")
	private String tableNm;
	@Column(name = "import_stmnts")
	private String importStmnts;
	@Column(name = "project_id")
	private String projectId;
	@Column(name = "queries")
	private String queries;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id")
	private Set<MethodInfo> methods = new HashSet<>();
	@Column(name = "session_attributes")
	private String sessionAttributes;
	@Column(name = "proposed_services")
	private String proposedServices;

	public String getProposedServices() {
		return proposedServices;
	}

	public void setProposedServices(String proposedServices) {
		this.proposedServices = proposedServices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<MethodInfo> getMethods() {
		return methods;
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

	public void setMethods(Set<MethodInfo> methods) {
		this.methods = methods;
	}

	public String getTableNm() {
		return tableNm;
	}

	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	@Override
	public String toString() {
		return "ClassInfo [id=" + id + ", className=" + className + ", packageName=" + packageName + ", sterioType="
				+ sterioType + ", noOfMethods=" + noOfMethods + ", interfaces=" + interfaces + ", superClass="
				+ superClass + ", loc=" + loc + ", annotations=" + annotations + ", sourceCode=" + sourceCode
				+ ", tableNm=" + tableNm + ", importStmnts=" + importStmnts + ", projectId=" + projectId + ", methods="
				+ methods + ", sessionAttributes=" + sessionAttributes + "]";
	}

}