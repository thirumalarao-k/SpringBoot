package com.hcl.msa.entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="JOB")
public class Job implements Serializable { 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GenericGenerator(name = "sequence_job_id", strategy = "com.hcl.msa.util.JobIdGenerator")
	@GeneratedValue(generator = "sequence_job_id")
	@Column(name = "Job_Id")
	private String jobId;
	@Column(name="project_id")
	private String projectId;
	@Column(name="job_name")
	private String jobName;
	@Column(name="created_time")
	private String createdTime;
	@Column(name="updated_time")
	private String updatedTime;
	@Column(name="additional_info")
	private String additionalInfo;
	@Column(name="job_type")
	private String jobType;
	@Column(name="status")
	private String status;
	@Column(name="project_name")
	private String projectName;
		
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
} 