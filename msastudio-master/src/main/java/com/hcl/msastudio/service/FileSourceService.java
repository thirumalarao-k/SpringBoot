package com.hcl.msastudio.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
import org.springframework.util.FileSystemUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.msastudio.domain.ClassInfo;
import com.hcl.msastudio.domain.MethodInfo;
import com.hcl.msastudio.util.MSAMessageProducer;
import com.hcl.msastudio.util.UnzipUtility;


@Service
public class FileSourceService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;

	public String getClassSource(String projectId,String className){
		logger.debug("Entering Method: getClassSource");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String uri = msaRestServiceUrl+"classinfo/" + projectId+"/getSource/"+className;
		//String uri = msaRestServiceUrl + "classinfos/"+ projectId;
		ResponseEntity < List < ClassInfo >> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<ClassInfo>> () {});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String classSrc = "";
		if(response != null) {
			List<ClassInfo> dtoList=response.getBody();
			
			if(!dtoList.isEmpty()) {
				classSrc = dtoList.get(0).getSourceCode();
			}
		}
		
		return classSrc;
	}
	
	public String getMethodSource(String projectId, String className, String methodName){
		logger.debug("Entering Method: getMethodSource");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String uri = msaRestServiceUrl+"classinfo/" + projectId+"/getSource/"+className;
		//String uri = msaRestServiceUrl + "classinfos/"+ projectId;
		ResponseEntity < List < ClassInfo >> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<ClassInfo>> () {});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String methodSrc = "";
		if(response != null) {
			List<ClassInfo> dtoList=response.getBody();			
			if(!dtoList.isEmpty()) {
				Set<MethodInfo> methodSet = dtoList.get(0).getMethods();
				if(!methodSet.isEmpty()) {
					for (MethodInfo methodInfo : methodSet) {
						if(methodInfo.getMethodName() != null && methodInfo.getMethodName().equals(methodName) && methodInfo.getMethodBody() != null ) {
							methodSrc = methodInfo.getMethodBody();
						}
						
					}
				}
			}
		}
		return methodSrc;
	}
	
}