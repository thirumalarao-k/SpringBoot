package com.hcl.msastudio.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msastudio.domain.ProjectDTO;
import com.hcl.msastudio.service.MSAMasterReportService;
import com.hcl.msastudio.service.MSAMicroReportService;



@RestController
public class MSAMicroServiceReportController {


	private static final Logger logger = LoggerFactory.getLogger(MSAMicroServiceReportController.class);
	
	@Autowired
	MSAMasterReportService masterReportService;
	
	@Autowired
	MSAMicroReportService microReportService;

	@GetMapping(value = "/test")
	public String getName() {
		return "Getting Policy controller Care API-Changed";
	}
	
	@GetMapping(value = "/microservice")	
	public ModelAndView getAllProjects( @ModelAttribute("SpringWeb")ProjectDTO emp, ModelMap modelMap ) throws Exception {
 
		ModelAndView modelAndView = new ModelAndView("microservice");
		modelMap.addAttribute("projects", masterReportService.getAllProjects());
		modelAndView.addAllObjects(modelMap);
		return modelAndView;
	}
	
	@PostMapping(value = "/microserviceReport")
	public ModelAndView getMicroServiceAnalysis(@RequestParam("projectId")String projectId) {
		ModelMap model = new ModelMap();
		if(null != projectId && !projectId.isEmpty()) {
			String[] projectInfo = projectId.split(":");
			if(projectInfo.length > 0) {
				//model.addAttribute("reports",microReportService.getMicroServiceAnalysisReport(projectInfo[0],projectInfo[1]));
				model.addAttribute("projectId",projectInfo[0]);
				model.addAttribute("technology",projectInfo[1]);
				if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("ejb") < 0)) {
					return new ModelAndView("microservicereportEJB", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("spring") < 0)) {
					return new ModelAndView("microservicereportSpring", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("struts") < 0))  {
					return new ModelAndView("microservicereportStruts", model);
				}
			}
				
		}
		return new ModelAndView("genericError", model);

	}
	
	@GetMapping(value = "/microserviceReportJSON")
	public ResponseEntity<String> getMicroServiceAnalysisJSON(@RequestParam("projectId")String projectId,@RequestParam("technology")String technology) {
		return microReportService.getMicroServiceAnalysisReportAsJSON(projectId,technology);
	}
	
	@GetMapping( value = "/microserviceReportChart")
	public ModelAndView getMicroServiceAnalysisChart() {
	
		ModelMap model = new ModelMap();
		//model.addAttribute("reports",microReportService.getMicroServiceAnalysisReport(projectId));
		return new ModelAndView("microservicereport1", model);

	}
	
	@GetMapping( value = "/circularChart")
	public ModelAndView getCircularChart() {
	
		ModelMap model = new ModelMap();
		//model.addAttribute("reports",microReportService.getMicroServiceAnalysisReport(projectId));
		return new ModelAndView("circularchart", model);

	}
	@GetMapping(value = "/circularChartJSON")
	public ResponseEntity<String> geCircualrChartJSON(@RequestParam("projectId")String projectId,@RequestParam("technology")String technology) {
		return microReportService.getDataForCircularChart(projectId,technology);
	}
	
	@GetMapping( value = "/expandableTreeTable")
	public ModelAndView getExpandableTreeTable() {
	
		ModelMap model = new ModelMap();
		//model.addAttribute("reports",microReportService.getMicroServiceAnalysisReport(projectId));
		return new ModelAndView("expandableTreeTable", model);

	}
}
