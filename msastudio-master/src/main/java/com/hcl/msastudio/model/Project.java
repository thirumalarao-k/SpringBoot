package com.hcl.msastudio.model;

import com.hcl.msastudio.domain.TechnologyInfo;

public class Project {

	private String projectName;
	private String projectId;
	private TechnologyInfo technologyInfo;
	
	public Project() {
		
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public TechnologyInfo getTechnologyInfo() {
		return technologyInfo;
	}

	public void setTechnologyInfo(TechnologyInfo technologyInfo) {
		this.technologyInfo = technologyInfo;
	}


}
