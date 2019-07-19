package com.ktr.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getproduct/{prodId}")
	public String getProduct(@PathVariable("prodId") String prodId){
		String url = "http://PRODUCTJPASERVICE/getproduct/"+prodId;
		return restTemplate.getForObject(url,String.class);
		
	}

}
