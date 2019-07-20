package com.hcl.msa.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="method_call_hierarchy")
public class MethodCallHierarchy implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	@Column(name="method_ref")
	private String methodRef;
	@Column(name="method_ref_params")
	private String methodRefParams;
	@Column(name="object_ref")
	private String objectRef;
	@Column(name="object_ref_definedIn")
	private String objectRefDefineType;
	@Column(name="method_sequence")
	private String methodSequence; 
	@Column(name="integration_comp")
	private String integrationComp;
	@Column(name="technology")
	private String technology;
	@Column(name="table_names")
	private String tableNms;
	@Column(name="proposed_service")
	private String proposedMicroService;
	@Column(name="compensating_service")
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "MethodCallHierarchy [id=" + id + ", methodRef=" + methodRef + ", methodRefParams=" + methodRefParams
				+ ", objectRef=" + objectRef + ", objectRefDefineType=" + objectRefDefineType + ", methodSequence="
				+ methodSequence + ", integrationComp=" + integrationComp + ", technology=" + technology + ", tableNms="
				+ tableNms + ", proposedMicroService=" + proposedMicroService + ", compensatingService="
				+ compensatingService + "]";
	}


} 