package com.hcl.msa.bean;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ProjectFileInfo implements Serializable { 
	
	
	private String filePath;
	
	private String fileName;

	private String fileExtn;
	
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
	@Override
	public String toString() {
		return "ProjectFileInfo [filePath=" + filePath + ", fileName=" + fileName + ", fileExtn=" + fileExtn
				+ ", projectId=" + projectId + "]";
	}
	
	
	
} 