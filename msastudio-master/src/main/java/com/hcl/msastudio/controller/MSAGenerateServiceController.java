package com.hcl.msastudio.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MSAGenerateServiceController {
	
	@Value("${data.service.url}")
	private String BASE_URL_MSA_REST_SERVICE = "";
	
	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/getControllers")
	public String generateMicroService1(Map<String, Object> model) {	
		String url = BASE_URL_MSA_REST_SERVICE+"classinfos";		
		Object[] response=null;
		try {
			response = restTemplate.getForObject(url, Object[].class,2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.put("data", response);
		//target html file name without extension
		return "generateMicroService1";
	}

}