package com.hcl.msa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msa.entity.Project;


public interface ProjectRepository  extends JpaRepository<Project, String>{
	
}
 