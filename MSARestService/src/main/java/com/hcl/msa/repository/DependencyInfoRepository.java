package com.hcl.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.msa.entity.DependencyInfo;

public interface DependencyInfoRepository extends JpaRepository<DependencyInfo, Integer> {

	Iterable<DependencyInfo> findByProjectId(String projectId);

}
