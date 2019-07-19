package com.hcl.msa.service;

import java.util.List;

import com.hcl.msa.entity.Job;

public interface JobService {
	public String createJob(Job job);

	public List<Job> getAllJobs(String projectId);

	public int updateJob(Job job);

	public Job findByJobId(String jobId);

	public List<Job> getAllJobs();
}
