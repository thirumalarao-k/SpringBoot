package com.ktr.sb.ssl.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSLController {
	
	@GetMapping("/hi/{name}")
	public String sayHi(@PathVariable("name") String name){
		return "Hi..."+name;
		
	}

}
