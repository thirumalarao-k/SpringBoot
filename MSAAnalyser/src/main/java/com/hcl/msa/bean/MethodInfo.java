package com.hcl.msa.bean;
import java.io.Serializable;
import java.util.Set;


@SuppressWarnings("serial")
public class MethodInfo implements Serializable { 
	private String methodName; 
	private String noOfParams; 
	private String methodBody; 
	private String methodParams; 
	private String returnType; 
	private String methodSignature; 
	private String loc;
	private String classId; 
	private String annotations;
	private String httpMethod;
	private String sessionAttributes; 
	private Set<MethodCallHierarchy> methodCallHierarchy;
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
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
	public Set<MethodCallHierarchy> getMethodCallHierarchy() {
		return methodCallHierarchy;
	}
	public void setMethodCallHierarchy(Set<MethodCallHierarchy> methodCallHierarchy) {
		this.methodCallHierarchy = methodCallHierarchy;
	}
	
	public String getAnnotations() {
		return annotations;
	}
	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	@Override
	public String toString() {
		return "MethodInfo [methodName=" + methodName + ", noOfParams=" + noOfParams + ", methodBody=" + methodBody
				+ ", methodParams=" + methodParams + ", returnType=" + returnType + ", methodSignature="
				+ methodSignature + ", loc=" + loc + ", classId=" + classId + ", annotations=" + annotations
				+ ", httpMethod=" + httpMethod + ", methodCallHierarchy=" + methodCallHierarchy + "]";
	}
	
	
} 