package com.hcl.msa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.msa.entity.Job;
import com.hcl.msa.repository.JobRepository;
import com.hcl.msa.service.JobService;


@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepository;

	public String createJob(Job job) {
		Job job1 = jobRepository.save(job);
		return job1.getJobId();
	}

	@Override
	public List<Job> getAllJobs(String projectId) {
		System.out.println("Getting All Jobs");
		List<Job> jobs = new ArrayList<Job>();
		jobRepository.findByProjectId(projectId).forEach(jobs::add);
		System.out.println("Job Fetched");
		return jobs;
	}

	@Override
	public int updateJob(Job job) {
		int result=jobRepository.updateJobStatus(job.getJobId(),job.getStatus(),job.getUpdatedTime());
		return result;

	}

	@Override
	public Job findByJobId(String jobId) {
		return jobRepository.findByJobId(jobId);
	}

	@Override
	public List<Job> getAllJobs() {
		List<Job> jobs = new ArrayList<Job>();
		jobs = jobRepository.findAll();
		return jobs;
	}

}
