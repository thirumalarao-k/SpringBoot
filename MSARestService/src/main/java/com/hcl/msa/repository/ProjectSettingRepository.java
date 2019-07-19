package com.hcl.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.msa.entity.ProjectSetting;

public interface ProjectSettingRepository extends JpaRepository<ProjectSetting, String> {
	ProjectSetting findByProjectName(String projectName);
}
