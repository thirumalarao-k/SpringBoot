package com.hcl.msa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;

@Entity
@Table(name = "PROJECT_SETTING")
@SQLInsert(sql="INSERT INTO PROJECT_SETTING(created_by,technology_id, project_name) VALUES (?, ?, ?) "
		+ "ON DUPLICATE KEY UPDATE technology_id = technology_id,created_by=created_by" )
public class ProjectSetting implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "project_name", length = 100)
	private String projectName;
	
	@Column(name = "technology_id", length = 100)
	private int technologyId;

	@Column(name = "created_by")
	private String createdBy;
	
	@ManyToOne
	@JoinColumn(name = "technology_id",insertable=false, updatable=false)
	private TechnologyInfo technologyInfo;

	public String getProjName() {
		return projectName;
	}

	public void setProjName(String projName) {
		this.projectName = projName;
	}

	public int getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(int technologyId) {
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