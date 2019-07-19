package com.hcl.msa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.msa.entity.ProjectFileInfo;
import com.hcl.msa.repository.ProjectFileInfoRepository;
import com.hcl.msa.service.ProjectFileInfoService;
@Service
public class ProjectFileInfoServiceImpl implements ProjectFileInfoService{
	@Autowired
	private ProjectFileInfoRepository projectFileInfoRepository;
	
	@Override
	public List<ProjectFileInfo> getAllProjectFileInfos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectFileInfo getProjectFileInfoById(int projectFileInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProjectFileInfo(List<ProjectFileInfo> projectFileInfo) {	
		
		projectFileInfoRepository.save(projectFileInfo);
	}

	@Override
	public void updateProjectFileInfo(ProjectFileInfo projectFileInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProjectFileInfo(int projectFileInfoId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProjectFileInfo getProjectFileInfoByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
