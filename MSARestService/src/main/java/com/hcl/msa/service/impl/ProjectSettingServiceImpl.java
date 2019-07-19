package com.hcl.msa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.msa.entity.Project;
import com.hcl.msa.entity.ProjectSetting;
import com.hcl.msa.entity.TechnologyInfo;
import com.hcl.msa.repository.ProjectSettingRepository;
import com.hcl.msa.repository.TechnologyInfoRepository;
import com.hcl.msa.service.ProjectSettingService;

@Service
public class ProjectSettingServiceImpl implements ProjectSettingService {
	@Autowired
	private ProjectSettingRepository projectSettingRepository;
	
	@Autowired
	private TechnologyInfoRepository technologyInfoRepository;

	@Override
	public List<TechnologyInfo> getTechnologies() {
		System.out.println("Getting All Technologies");
		List<TechnologyInfo> techs = new ArrayList<>();
		technologyInfoRepository.findAll().forEach(techs::add);
		System.out.println("Technologies Fetched");
		return techs;
	}
	
	@Override
	public String addProjectSetting(ProjectSetting projSetting) {
		ProjectSetting projSet = projectSettingRepository.save(projSetting);
		return projSet.getProjName();
	}

	@Override
	public ProjectSetting getProjectSetting(String projName) {
		ProjectSetting projSet = projectSettingRepository.findByProjectName(projName);
		return projSet;
	}

	
	
}
