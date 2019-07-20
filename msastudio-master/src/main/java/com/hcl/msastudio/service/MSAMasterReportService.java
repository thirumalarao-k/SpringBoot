package com.hcl.msastudio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.msastudio.domain.ClassInfo;
import com.hcl.msastudio.domain.JobDTO;
import com.hcl.msastudio.domain.MethodInfo;
import com.hcl.msastudio.domain.MicroAnalyseDTO;
import com.hcl.msastudio.domain.ProjectDTO;
import com.hcl.msastudio.model.Job;
import com.hcl.msastudio.model.Project;

@Service
public class MSAMasterReportService {

	private static final Logger logger = LoggerFactory.getLogger(MSAMasterReportService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;
	
	public List<ProjectDTO> getAllProjects() {
		logger.debug("Entering Method: getAllPolicies");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		// String dataserviceUrl = "http://localhost:9090/api";
		String uri = msaRestServiceUrl + "/projects";

	
		ResponseEntity < List < Project >> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<Project>> () {});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<ProjectDTO> dtoList=new ArrayList<ProjectDTO>();
		for (int i = 0; i < response.getBody().size(); i++) {
			ProjectDTO dto = new ProjectDTO();
			Project project = response.getBody().get(i);
			dto.setProjectId(project.getProjectId());
			dto.setProjectName(project.getProjectName());
			dto.setTechnology(project.getTechnologyInfo().getTechnology());
			dtoList.add(dto);
		}
		return dtoList;
	}

	public List<JobDTO> getAllJobs(String projectId) {
		logger.debug("Entering Method: getAllPolicies");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		String uri = msaRestServiceUrl + "/projects/" + projectId;

		ResponseEntity<List> result = null;

		try {
			result = restTemplate.exchange(uri, HttpMethod.GET, entity, List.class);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		ResponseEntity < List < Job >> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<Job>> () {});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<JobDTO> dtoList=new ArrayList<JobDTO>();
		for (int i = 0; i < response.getBody().size(); i++) {
			JobDTO dto = new JobDTO();
			Job job = response.getBody().get(i);
			dto.setJobId(job.getJobId());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
}
