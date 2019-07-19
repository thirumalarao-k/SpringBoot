package com.hcl.msastudio.domain;
import java.io.Serializable;


public class MethodCallHierarchy implements Serializable { 
	private static final long serialVersionUID = 1L;
	private String id; 
	private String methodId; 
	private String methodRef;
	private String methodRefParams;
	private String methodSequence; 
	private String objectRef;
	private String objectRefDefineType;
	private String integrationComp;
	private String technology;
	//Added property to capture list of tables used at method level
	private String tableNms;
	
	private String proposedMicroService;
	private String compensatingService;
	
	public String getProposedMicroService() {
		return proposedMicroService;
	}
	public void setProposedMicroService(String proposedMicroService) {
		this.proposedMicroService = proposedMicroService;
	}
	public String getCompensatingService() {
		return compensatingService;
	}
	public void setCompensatingService(String compensatingService) {
		this.compensatingService = compensatingService;
	}

	public String getTableNms() {
		return tableNms;
	}
	public void setTableNms(String tableNms) {
		this.tableNms = tableNms;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMethodId() {
		return methodId;
	}
	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}
	public String getMethodRef() {
		return methodRef;
	}
	public void setMethodRef(String methodRef) {
		this.methodRef = methodRef;
	}
	public String getMethodRefParams() {
		return methodRefParams;
	}
	public void setMethodRefParams(String methodRefParams) {
		this.methodRefParams = methodRefParams;
	}
	public String getMethodSequence() {
		return methodSequence;
	}
	public void setMethodSequence(String methodSequence) {
		this.methodSequence = methodSequence;
	}
	public String getObjectRef() {
		return objectRef;
	}
	public void setObjectRef(String objectRef) {
		this.objectRef = objectRef;
	}
	public String getObjectRefDefineType() {
		return objectRefDefineType;
	}
	public void setObjectRefDefineType(String objectRefDefineType) {
		this.objectRefDefineType = objectRefDefineType;
	}
	public String getIntegrationComp() {
		return integrationComp;
	}
	public void setIntegrationComp(String integrationComp) {
		this.integrationComp = integrationComp;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	@Override
	public String toString() {
		return "MethodCallHierarchy [id=" + id + ", methodId=" + methodId + ", methodRef=" + methodRef
				+ ", methodRefParams=" + methodRefParams + ", methodSequence=" + methodSequence + ", objectRef="
				+ objectRef + ", objectRefDefineType=" + objectRefDefineType + ", integrationComp=" + integrationComp
				+ ", technology=" + technology + ", tableNms=" + tableNms + ", proposedMicroService="
				+ proposedMicroService + ", compensatingService=" + compensatingService + "]";
	}
	
	
	
} 