package com.hcl.msa.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.msa.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

	Iterable<Job> findByProjectId(String projectId);

	Job findByJobId(String jobId);
	
	@Modifying
	@Transactional
	@Query("UPDATE Job j SET j.status = :status, j.updatedTime = :updatedTime WHERE j.jobId = :jobId")
	int updateJobStatus(@Param("jobId")String jobId, @Param("status")String status, @Param("updatedTime")String updatedTime);
	

}
