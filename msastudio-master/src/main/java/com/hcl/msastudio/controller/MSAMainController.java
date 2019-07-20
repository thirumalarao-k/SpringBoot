package com.hcl.msastudio.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping(path = "/msastudio")
public class MSAMainController {
/*
	@GetMapping(value = "/login")
	public String loginPage(Map<String, Object> model) {
		return "login";
	}*/
	
	
/*	@RequestMapping("/analyseMicroService")
	public String analyseMicroService(Map<String, Object> model) {
		return "analyseMicroService";
	}*/
	
	@RequestMapping("/analyseresult")
	public String analyseResult(Map<String, Object> model) {
		return "analyseresult";
	}
	
	@RequestMapping("/scheduledjob")
	public String listScheduledJobs(Map<String, Object> model) {
		return "scheduledjob";
	}
	
	@RequestMapping("/completedjob")
	public String listCompletedJobs(Map<String, Object> model) {
		return "completedjob";
	}	
	
	@RequestMapping("/microservice")
	public String getMicroService(Map<String, Object> model) {
		return "microservice";
	}
	
	@RequestMapping("/microservicereport")
	public String getMicroserviceReport(Map<String, Object> model) {
		return "microservicereport";
	}
	
	@RequestMapping("/sessioninfo")
	public String getSessionInfo(Map<String, Object> model) {
		return "sessioninfo";
	}
	
	@RequestMapping("/sessiondetailreport")
	public String getSessionDetailReport(Map<String, Object> model) {
		return "sessiondetailreport";
	}
	
	@RequestMapping("/datamodel")
	public String getDatamodel(Map<String, Object> model) {
		return "datamodel";
	}
	
	@RequestMapping("/datamodelreport")
	public String getDatamodelReport(Map<String, Object> model) {
		return "datamodelreport";
	}
	
	@RequestMapping("/transactioninfo")
	public String getTransactionInfo(Map<String, Object> model) {
		return "transactioninfo";
	}
	
	@RequestMapping("/transactionreport")
	public String getTransactionReport(Map<String, Object> model) {
		return "transactionreport";
	}
	
	@RequestMapping("/objectreference")
	public String getObjectReference(Map<String, Object> model) {
		return "objectreference";
	}
	
	@RequestMapping("/objectreferencereport")
	public String getObjectReferenceReport(Map<String, Object> model) {
		return "objectreferencereport";
	}
	
	@RequestMapping("/integrationpoint")
	public String getIntegrationPoint(Map<String, Object> model) {
		return "integrationpoint";
	}
	
	@RequestMapping("/integrationreport")
	public String getIntegrationReport(Map<String, Object> model) {
		return "integrationreport";
	}
	
	@RequestMapping("/dependency")
	public String getDependency(Map<String, Object> model) {
		return "dependency";
	}
	
	@RequestMapping("/dependencyreport")
	public String getDependencyReport(Map<String, Object> model) {
		return "dependencyreport";
	}
	
	@RequestMapping("/vulnerability")
	public String getVulnerability(Map<String, Object> model) {
		return "vulnerability";
	}
	
	@RequestMapping("/vulnerabilityreport")
	public String getVulnerabilityreport(Map<String, Object> model) {
		return "vulnerabilityreport";
	}

	@RequestMapping("/generateMicroService")
	public String generateMicroService(Map<String, Object> model) {
		return "generateMicroService";
	}
	
	@RequestMapping("/generateMicroService1")
	public String generateMicroService1(Map<String, Object> model) {
		return "generateMicroService1";
	}	
	
	@RequestMapping("/generateMicroService2")
	public String generateMicroService2(Map<String, Object> model) {
		return "generateMicroService2";
	}
	
	@RequestMapping("/generateMicroService3")
	public String generateMicroService3(Map<String, Object> model) {
		return "generateMicroService3";
	}
	@RequestMapping("/index")
	public String index(Map<String, Object> model) {
		return "index";
	}
	@RequestMapping("/charts")
	public String charts(Map<String, Object> model) {
		return "charts";
	}
}