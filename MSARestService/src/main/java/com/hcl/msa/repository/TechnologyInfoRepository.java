package com.hcl.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.msa.entity.TechnologyInfo;

public interface TechnologyInfoRepository extends JpaRepository<TechnologyInfo, Integer> {
	
}
