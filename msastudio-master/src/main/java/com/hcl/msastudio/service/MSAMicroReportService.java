package com.hcl.msastudio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.msastudio.domain.MethodCallHierarchy;
import com.hcl.msastudio.domain.ClassInfo;
import com.hcl.msastudio.domain.MethodInfo;
import com.hcl.msastudio.model.chart.ClassData;
import com.hcl.msastudio.model.chart.MethodData;
import com.hcl.msastudio.model.chart.Project;

@Service
public class MSAMicroReportService {

	private static final Logger logger = LoggerFactory.getLogger(MSAMicroReportService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${data.service.url}")
	private String msaRestServiceUrl;
	
	

	public List<ClassInfo> getMicroServiceAnalysisReport(String jobId, String technology) {
		logger.debug("Entering Method: getAllPolicies");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		//String uri = msaRestServiceUrl +"/" + jobId+"/classinfos";
		String uri;
		if(null != technology && !(technology.toLowerCase().indexOf("ejb") < 0)) {//Ejb beans
			uri = msaRestServiceUrl + jobId+"/sterioTypes/sessionbean,messagedrivenbean,entitybean";
		}else {//mvc controllers
			uri = msaRestServiceUrl + jobId+"/sterioType/controller";
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
	
	public  ResponseEntity<String> getMicroServiceAnalysisReportAsJSON(String jobId, String technology) {
		logger.debug("Entering Method: getAllPolicies");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String uri;
		if(null != technology && !(technology.toLowerCase().indexOf("ejb") < 0)) {//Ejb beans
			uri = msaRestServiceUrl + jobId+"/sterioTypes/sessionbean,messagedrivenbean,entitybean";
		}else {//mvc controllers
			uri = msaRestServiceUrl + jobId+"/sterioType/controller";
		}
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

	public  ResponseEntity<String> getDataForCircularChart(String jobId, String technology){
		logger.debug("Entering Method: getAllPolicies");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity <String> response=null;
		String uri;
		if(null != technology && !(technology.toLowerCase().indexOf("ejb") < 0)) {//Ejb beans
			uri = msaRestServiceUrl + jobId+"/sterioTypes/sessionbean,messagedrivenbean,entitybean";
		}else {//mvc controllers
			uri = msaRestServiceUrl + jobId+"/sterioType/controller";
		}
		ResponseEntity < List < ClassInfo >> resp=null;
		try {
			resp = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<ClassInfo>> () {});
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ClassInfo> dtoList=resp.getBody();
		
		
		Project project = getChartData(dtoList,jobId);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(project);
			response= new ResponseEntity<String>(jsonInString,HttpStatus.OK);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	private Project getChartData(List<ClassInfo> classInfos,String jobId) {
		
		
		Project project=new Project();
		project.setName(jobId);
		ArrayList cInfos=new ArrayList();
		for (Iterator iterator = classInfos.iterator(); iterator.hasNext();) {
			ClassInfo classInfo = (ClassInfo) iterator.next();
			ClassData ci1=new ClassData();
			ci1.setName(classInfo.getClassName());
			Set methods=classInfo.getMethods();
			ArrayList mInfos=new ArrayList();
			for (Iterator iterator2 = methods.iterator(); iterator2.hasNext();) {
				MethodInfo mInfo = (MethodInfo) iterator2.next();
				MethodData m1=new MethodData();
	
				Set mchs=mInfo.getMethodCallHierarchy();
				int proposedMSCount=0;
				Set proposedServices=new HashSet();
				for (Iterator iterator3 = mchs.iterator(); iterator3.hasNext();) {
					MethodCallHierarchy mch = (MethodCallHierarchy) iterator3.next();
					if(mch.getProposedMicroService()!=null) {
						proposedMSCount=proposedMSCount+1;
						proposedServices.add(mch.getProposedMicroService());
					}
				}
				proposedMSCount=proposedServices.size();
				if(proposedMSCount>0) {
					m1.setName(mInfo.getMethodName());
					m1.setSize(proposedMSCount);
					mInfos.add(m1);
				}
				
			}
			ci1.setChildren(mInfos);
			cInfos.add(ci1);
			
		}
		project.setChildren(cInfos);
		return project;
	}
}
