package com.hcl.msastudio.model;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	private String projectType;
	private MultipartFile file;
	
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
