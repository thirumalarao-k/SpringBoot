package com.hcl.msastudio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hcl.msastudio.domain.JobDTO;

@Service
public class JobAnalyseService {
	
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;
	

	public List<JobDTO> getAllJobs() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String uri = msaRestServiceUrl + "jobs";

		ResponseEntity<List<JobDTO>> response = null;
		try {
			response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<JobDTO>>() {
			});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<JobDTO> dtoList = response.getBody();
		return dtoList;
	}

}
