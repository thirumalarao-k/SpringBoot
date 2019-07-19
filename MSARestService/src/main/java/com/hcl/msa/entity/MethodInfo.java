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
@Table(name="class_method_info")
public class MethodInfo implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	@Column(name="method_name")
	private String methodName; 
	@Column(name="no_of_params")
	private String noOfParams; 
	@Column(name="method_body",length=60000)
	private String methodBody; 
	@Column(name="method_params",length=1000)
	private String methodParams; 
	@Column(name="return_type")
	private String returnType; 
	@Column(name="method_signature",length=500)
	private String methodSignature; 
	@Column(name="loc")
	private String loc;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "method_id")
	private Set<MethodCallHierarchy> methodCallHierarchy=new HashSet<>();
	@Column(name = "session_attributes")
	private String sessionAttributes;
	@Column(name = "method_annotations")
	private String annotations;
	public String getAnnotations() {
		return annotations;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public Set<MethodCallHierarchy> getMethodCallHierarchy() {
		return methodCallHierarchy;
	}
	
	public void setMethodCallHierarchy(Set<MethodCallHierarchy> methodCallHierarchy) {
		this.methodCallHierarchy = methodCallHierarchy;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getNoOfParams() {
		return noOfParams;
	}
	public void setNoOfParams(String noOfParams) {
		this.noOfParams = noOfParams;
	}
	public String getMethodBody() {
		return methodBody;
	}
	public void setMethodBody(String methodBody) {
		this.methodBody = methodBody;
	}
	public String getMethodParams() {
		return methodParams;
	}
	public void setMethodParams(String methodParams) {
		this.methodParams = methodParams;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getMethodSignature() {
		return methodSignature;
	}
	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getSessionAttributes() {
		return sessionAttributes;
	}

	public void setSessionAttributes(String sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	@Override
	public String toString() {
		return "MethodInfo [id=" + id + ", methodName=" + methodName + ", noOfParams=" + noOfParams + ", methodBody="
				+ methodBody + ", methodParams=" + methodParams + ", returnType=" + returnType + ", methodSignature="
				+ methodSignature + ", loc=" + loc + ", methodCallHierarchy=" + methodCallHierarchy
				+ ", sessionAttributes=" + sessionAttributes + "]";
	}

	
	
	
	
} 