package com.hcl.msastudio.domain;

public class ProjectSetting {
	private String projectName;
	private String technologyId;
	private String createdBy;
	private TechnologyInfo technologyInfo;

	public String getProjName() {
		return projectName;
	}

	public void setProjName(String projName) {
		this.projectName = projName;
	}

	public String getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(String technologyId) {
		this.technologyId = technologyId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public TechnologyInfo getTechnologyInfo() {
		return technologyInfo;
	}

	public void setTechnologyInfo(TechnologyInfo technologyInfo) {
		this.technologyInfo = technologyInfo;
	}

	@Override
	public String toString() {
		return "ProjectSetting [projName=" + projectName + ", technologyId=" + technologyId + ", createdBy=" + createdBy
				+ ", technologyInfo=" + technologyInfo + "]";
	}
	

}