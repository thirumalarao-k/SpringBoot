package com.hcl.msa.bean;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Project implements Serializable { 
    private String projectName;
	private String sourceCodeLocation;
	private String sourcePackageName;
	private String createdBy;
	private String modifiedBy;
	private String createdDateTime;
	private String modifiedDateTime;
	private int technologyId;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getSourceCodeLocation() {
		return sourceCodeLocation;
	}
	public void setSourceCodeLocation(String sourceCodeLocation) {
		this.sourceCodeLocation = sourceCodeLocation;
	}
	public String getSourcePackageName() {
		return sourcePackageName;
	}
	public void setSourcePackageName(String sourcePackageName) {
		this.sourcePackageName = sourcePackageName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	public String getModifiedDateTime() {
		return modifiedDateTime;
	}
	public void setModifiedDateTime(String modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
	public int getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}
	
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", sourceCodeLocation=" + sourceCodeLocation
				+ ", sourcePackageName=" + sourcePackageName + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdDateTime=" + createdDateTime + ", modifiedDateTime=" + modifiedDateTime + ", technologyId="
				+ technologyId + "]";
	}
} 