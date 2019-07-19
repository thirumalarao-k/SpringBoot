package com.hcl.msa.controller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.hcl.msa.entity.ProjectFileInfo;
import com.hcl.msa.service.ProjectFileInfoService;

@Controller
@RequestMapping("msa")
public class ProjectFileInfoController {
	private final static Logger LOGGER = Logger.getLogger(ProjectFileInfoController.class.getName());
	@Autowired
	private ProjectFileInfoService fileInfoService;
	
	@PostMapping("projectFileInfo")
	public ResponseEntity<String> addProjectFileInfo(@RequestBody List<ProjectFileInfo> projectFileInfo, UriComponentsBuilder builder) {
        try {
			fileInfoService.addProjectFileInfo(projectFileInfo);
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.getStackTrace().toString());;
		}
        return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
} 