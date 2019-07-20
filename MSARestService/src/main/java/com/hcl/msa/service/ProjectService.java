package com.hcl.msa.service;

import java.util.List;

import com.hcl.msa.entity.DependencyInfo;
import com.hcl.msa.entity.Project;

public interface ProjectService {
     List<Project> getAllProjects();
     Project getProjectById(String projectId);
     String addProject(Project project);
     void updateProject(Project project);
     void deleteProject(String projectId);
}
