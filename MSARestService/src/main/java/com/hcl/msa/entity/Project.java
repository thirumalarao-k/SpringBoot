package com.hcl.msa.entity;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PROJECT")
public class Project implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "sequence_proj_id", strategy = "com.hcl.msa.util.ProjectIdGenerator")
	@GeneratedValue(generator = "sequence_proj_id")
	@Column(name = "project_Id")
	private String projectId;
	@Column(name="project_name")
	private String projectName;
	@Column(name="source_zip_location",length=1000)
	private String sourceZipLocation;
	@Column(name="source_zip_name")
	private String sourceZipName;
	@Column(name="created_time")
	private Date createdTime;
	@Column(name="modified_time")
	private Date modifiedTime;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="modified_by")
	private String modifiedBy;
	@Column(name="status")
	private String status;
	@Column(name = "technology_id", length = 100)
	private int technologyId;
	
	@ManyToOne
	@JoinColumn(name = "technology_id",insertable=false, updatable=false)
	private TechnologyInfo technologyInfo;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getSourceZipLocation() {
		return sourceZipLocation;
	}
	public void setSourceZipLocation(String sourceZipLocation) {
		this.sourceZipLocation = sourceZipLocation;
	}
	public String getSourceZipName() {
		return sourceZipName;
	}
	public void setSourceZipName(String sourceZipName) {
		this.sourceZipName = sourceZipName;
	}
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}
	public TechnologyInfo getTechnologyInfo() {
		return technologyInfo;
	}
	public void setTechnologyInfo(TechnologyInfo technologyInfo) {
		this.technologyInfo = technologyInfo;
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", sourceZipLocation="
				+ sourceZipLocation + ", sourceZipName=" + sourceZipName + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", status=" + status + ", technologyId=" + technologyId + ", technologyInfo=" + technologyInfo + "]";
	}
	
} 