package com.hcl.msastudio.service;

import java.util.Arrays;
import java.util.List;

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
public class MSAObjectRefService {
	

	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;

	public List<ClassInfo> getObjectRefAnalysisReport(String projectId, String technology) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		String uri;
		if(null!= technology && !(technology.toLowerCase().indexOf("ejb") < 0)) {//Ejb beans
			uri = msaRestServiceUrl + projectId+"/sterioTypes/sessionbean,messagedrivenbean,entitybean";
		}else {//mvc controllers
			uri = msaRestServiceUrl + projectId+"/sterioType/controller";
		}
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

	public ResponseEntity<String> getObjectRefAnalysisReportJSON(String projectId, String technology) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		String uri;
		if(null!= technology && !(technology.toLowerCase().indexOf("ejb") < 0)) {//Ejb beans
			uri = msaRestServiceUrl + projectId+"/sterioTypes/sessionbean,messagedrivenbean,entitybean";
		}else {//mvc controllers
			uri = msaRestServiceUrl + projectId+"/sterioType/controller";
		}
		ResponseEntity <String> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <String> () {});
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		
		return response; 
	}
}
