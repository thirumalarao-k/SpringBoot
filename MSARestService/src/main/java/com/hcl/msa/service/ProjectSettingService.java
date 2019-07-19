package com.hcl.msa.service;

import java.util.List;

import com.hcl.msa.entity.ProjectSetting;
import com.hcl.msa.entity.TechnologyInfo;

public interface ProjectSettingService {
	
	 List<TechnologyInfo> getTechnologies();
	 String addProjectSetting(ProjectSetting projSetting);
	 ProjectSetting getProjectSetting(String projName);
	 
}
