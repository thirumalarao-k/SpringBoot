package com.hcl.msastudio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.hcl.msastudio.domain.DataModelDTO;
import com.hcl.msastudio.domain.DependencyDTO;
import com.hcl.msastudio.domain.MethodInfo;
import com.hcl.msastudio.domain.MicroAnalyseDTO;
import com.hcl.msastudio.domain.SessionDetailsDTO;

@Service
public class MSADependencyService  {

	private static final Logger logger = LoggerFactory.getLogger(MSADependencyService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;

	public List<DependencyDTO> getDependencyAnalysisReport(String projectId) {
		logger.debug("Entering Method: getAllPolicies");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String uri = msaRestServiceUrl + "dependencyInfo/"+ projectId;
		ResponseEntity < List < DependencyDTO >> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<DependencyDTO>> () {});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<DependencyDTO> dtoList=new ArrayList<DependencyDTO>();
		for (int i = 0; i < response.getBody().size(); i++) {
			DependencyDTO dtoresponse = new DependencyDTO();
			dtoresponse.setDependencyNm(response.getBody().get(i).getDependencyNm());
			dtoresponse.setDependencyLib(response.getBody().get(i).getDependencyNm());
			dtoresponse.setDependencyVersion(response.getBody().get(i).getDependencyVersion());
			dtoList.add(dtoresponse);
		}
		return dtoList;
	}

	public ResponseEntity<String> getDependencyAnalysisReportJSON(String projectId, String technology) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String uri = msaRestServiceUrl + "dependencyInfo/"+ projectId;
		ResponseEntity <String> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <String> () {});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
}
