package com.hcl.msa.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT_FILE_INFO")
public class ProjectFileInfo implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	@Column(name="file_path",length=1000)
	private String filePath;
	@Column(name="file_name")
	private String fileName;
	@Column(name="file_extn")
	private String fileExtn;
	@Column(name="project_id")
	private String projectId;


	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExtn() {
		return fileExtn;
	}
	public void setFileExtn(String fileExtn) {
		this.fileExtn = fileExtn;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ProjectFileInfo [id=" + id + ", filePath=" + filePath + ", fileName=" + fileName + ", fileExtn="
				+ fileExtn + ", projectId=" + projectId + "]";
	}
	
	
} 