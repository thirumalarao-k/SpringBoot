package com.hcl.msa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.msa.entity.Job;
import com.hcl.msa.service.JobService;


@CrossOrigin
@RequestMapping(path="/msa")
@RestController

public class JobController {
	
	private static final Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	JobService jobService;
	
	@GetMapping(value = "/projects/{projectId}")
	public ResponseEntity<List<Job>> getAllJobsByProjectId(@PathVariable String projectId) {
		List<Job> jobs = jobService.getAllJobs(projectId);
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/jobs")
	public ResponseEntity<List<Job>> getAllJobs() {
		List<Job> jobs = jobService.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
	
	@PostMapping(value = "/job", headers = "Accept=application/json")
	public ResponseEntity<?> addProject(@RequestBody Job job) {
		String jobId = null;
		if (job.getJobId() != null) {
			int result = jobService.updateJob(job);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			jobId = jobService.createJob(job);
			return new ResponseEntity<>(jobId, HttpStatus.OK);
		}

	}
	
	@PutMapping(value = "/job", headers = "Accept=application/json")
	public ResponseEntity<?> updateJobInfo(@RequestBody Job job) {
		jobService.updateJob(job);
		return new ResponseEntity<>(job.getJobId(), HttpStatus.OK);
	}
}
