package com.hcl.msa.service;

import java.util.List;

import com.hcl.msa.entity.DependencyInfo;

public interface DependencyInfoService {
	void saveDependencyInfo(List<DependencyInfo> dependencyInfo);

	List<DependencyInfo> getAllDependencies(String projectId);
}
