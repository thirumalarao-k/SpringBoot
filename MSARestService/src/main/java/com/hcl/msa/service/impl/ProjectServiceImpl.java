package com.hcl.msa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.msa.entity.Project;
import com.hcl.msa.repository.ProjectRepository;
import com.hcl.msa.service.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Override
	public List<Project> getAllProjects() {
		System.out.println("Getting All Projects");
		List<Project> projects = new ArrayList<Project>();
		projectRepository.findAll().forEach(projects::add);
		System.out.println("Project Fetched");
		return projects;
	}

	@Override
	public Project getProjectById(String projectId) {
		return projectRepository.findOne(projectId);
	}

	@Override
	public String addProject(Project project) {
		Project proj=projectRepository.save(project);
		 return proj.getProjectId();
	}

	@Override
	public void updateProject(Project project) {
		projectRepository.save(project);

	}

	@Override
	public void deleteProject(String projectId) {
		projectRepository.delete(projectId);
	}

}
