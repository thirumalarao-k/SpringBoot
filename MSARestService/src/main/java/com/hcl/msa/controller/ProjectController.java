package com.hcl.msa.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.hcl.msa.entity.Project;
import com.hcl.msa.entity.ProjectSetting;
import com.hcl.msa.entity.TechnologyInfo;
import com.hcl.msa.service.ProjectService;
import com.hcl.msa.service.ProjectSettingService;

@Controller
@RequestMapping("msa")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectSettingService projectSettingService;
	
	@GetMapping(value = "/projects")
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}
	
	@PostMapping("project")
	public ResponseEntity<String> addProject(@RequestBody Project project, UriComponentsBuilder builder) {
		String projectId = projectService.addProject(project);
        return new ResponseEntity<>(projectId, HttpStatus.OK);
	}
	
	@GetMapping(value = "/technologies")
	public ResponseEntity<List<TechnologyInfo>> getAllTechnologies() {
		List<TechnologyInfo> techInfos = projectSettingService.getTechnologies();
		return new ResponseEntity<List<TechnologyInfo>>(techInfos, HttpStatus.OK);
	}
	
	@PostMapping("projectSetting")
	public ResponseEntity<String> addProjectSetting(@RequestBody ProjectSetting projectSet, UriComponentsBuilder builder) {
		String projectName = projectSettingService.addProjectSetting(projectSet);
        return new ResponseEntity<>(projectName, HttpStatus.OK);
	}
	
	@GetMapping("projectSetting/{projectName}")
	public ResponseEntity<ProjectSetting> getProjectSetting(@PathVariable("projectName") String projectName, UriComponentsBuilder builder) {
		ProjectSetting projectSet = projectSettingService.getProjectSetting(projectName);
        return new ResponseEntity<>(projectSet, HttpStatus.OK);
	}
	

} 