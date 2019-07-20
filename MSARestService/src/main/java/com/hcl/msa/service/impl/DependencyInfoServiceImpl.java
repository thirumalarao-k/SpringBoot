package com.hcl.msa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.msa.entity.DependencyInfo;
import com.hcl.msa.repository.DependencyInfoRepository;
import com.hcl.msa.service.DependencyInfoService;

@Service
public class DependencyInfoServiceImpl implements  DependencyInfoService{

	@Autowired
	private DependencyInfoRepository repository;
	
	@Override
	public void saveDependencyInfo(List<DependencyInfo> dependencyInfos) {
		repository.save(dependencyInfos);
		System.out.println("Done");

	}

	@Override
	public List<DependencyInfo> getAllDependencies(String projectId) {
		System.out.println("Getting All Dependency Libraries");
		List<DependencyInfo> dependencies = new ArrayList<DependencyInfo>();
		repository.findByProjectId(projectId).forEach(dependencies::add);
		System.out.println("Libraries Fetched");
		return dependencies;
	}


	
}


