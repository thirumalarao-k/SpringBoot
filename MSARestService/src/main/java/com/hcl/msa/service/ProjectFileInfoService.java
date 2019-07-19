package com.hcl.msa.service;

import java.util.List;

import com.hcl.msa.entity.ProjectFileInfo;

public interface ProjectFileInfoService {
     List<ProjectFileInfo> getAllProjectFileInfos();
     ProjectFileInfo getProjectFileInfoById(int projectFileInfoId);
     void addProjectFileInfo(List<ProjectFileInfo> projectFileInfo);
     void updateProjectFileInfo(ProjectFileInfo projectFileInfo);
     void deleteProjectFileInfo(int projectFileInfoId);
     ProjectFileInfo getProjectFileInfoByProjectId(int projectId);
}
