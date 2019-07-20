package com.hcl.msastudio.service;

import java.util.Arrays;
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

@Service
public class MSATransactionalBoundaryService  {

	private static final Logger logger = LoggerFactory.getLogger(MSATransactionalBoundaryService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;
	
	

	public List<ClassInfo> getTransactionalBoundaryAnalysisReport(String projectId, String technology) {
		logger.debug("Entering Method: getAllPolicies");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String uri = msaRestServiceUrl +"classinfos/"+projectId+"/transactionInfo";
		ResponseEntity < List < ClassInfo >> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<ClassInfo>> () {});
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		List<ClassInfo> dtoList=response.getBody();
		
		return dtoList;
	}

	public Object getIntegrationPointReport(String jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<String> getTransactionalBoundaryAnalysisReportJSON(String projectId, String technology) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String uri = msaRestServiceUrl +"classinfos/"+projectId+"/transactionInfo";
		ResponseEntity<String> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <String> () {});
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
}
