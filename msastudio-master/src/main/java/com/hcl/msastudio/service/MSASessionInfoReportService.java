package com.hcl.msastudio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

import com.hcl.msastudio.domain.ClassInfo;
import com.hcl.msastudio.domain.MethodInfo;
import com.hcl.msastudio.domain.MicroAnalyseDTO;
import com.hcl.msastudio.domain.SessionDetailsDTO;

@Service
public class MSASessionInfoReportService {

	private static final Logger logger = LoggerFactory.getLogger(MSASessionInfoReportService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;


	public List<ClassInfo> getSessionDetailsAnalysisReport(String jobId, String technology) {
		logger.debug("Entering Method: getAllPolicies");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		String uri;
		if(null!= technology && !(technology.toLowerCase().indexOf("ejb") < 0)) {//Ejb beans
			uri = msaRestServiceUrl + jobId+"/sterioType/sessionbean";
		}else {//for other web modules using http session
			uri = msaRestServiceUrl + "classinfos/" + jobId +"/sessionInfo";
		}
		ResponseEntity<List<ClassInfo>> response = null;
		try {
			response = restTemplate.exchange(uri, HttpMethod.GET, null,	new ParameterizedTypeReference<List<ClassInfo>>() {
					});
		} catch (RestClientException e) {
			e.printStackTrace();
		}

		List<ClassInfo> dtoList = response.getBody();
	
		return dtoList;
	}


	public ResponseEntity<String> getSessionDetailsAnalysisReportAsJSON(String projectId, String technology) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		String uri;
		if(null!= technology && !(technology.toLowerCase().indexOf("ejb") < 0)) {//Ejb beans
			uri = msaRestServiceUrl + projectId+"/sterioType/sessionbean";
		}else {//for other web modules using http session
			uri = msaRestServiceUrl + "classinfos/" + projectId +"/sessionInfo";
		}
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(uri, HttpMethod.GET, null,	new ParameterizedTypeReference<String>() {
					});
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		
		return response;
	}


	
	
}
