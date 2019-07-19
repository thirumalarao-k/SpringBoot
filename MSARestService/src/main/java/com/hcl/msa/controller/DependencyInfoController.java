package com.hcl.msa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.hcl.msa.entity.DependencyInfo;
import com.hcl.msa.service.DependencyInfoService;

@Controller
@RequestMapping("msa")
public class DependencyInfoController {
	
	private Logger logger = LoggerFactory.getLogger(DependencyInfoController.class);
	
	@Autowired
	private DependencyInfoService service;
	
	@GetMapping("dependencyInfo/{projectId}")
	public ResponseEntity<List<DependencyInfo>> getDependencyInfo(@PathVariable String projectId) {
		List<DependencyInfo> info = service.getAllDependencies(projectId);
		return new ResponseEntity<List<DependencyInfo>>(info, HttpStatus.OK);
	}
	
	@PostMapping("dependencyInfo")
	public ResponseEntity<String> addDependencyInfo(@RequestBody List<DependencyInfo> dependencyInfo, UriComponentsBuilder builder) {
        try {
        	service.saveDependencyInfo(dependencyInfo);
		} catch (Exception e) {
			logger.info("Updated");;
		}
        return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
