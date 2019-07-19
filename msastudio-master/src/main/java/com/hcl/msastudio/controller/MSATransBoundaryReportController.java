package com.hcl.msastudio.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msastudio.service.MSAMasterReportService;
import com.hcl.msastudio.service.MSATransactionalBoundaryService;



@RestController
public class MSATransBoundaryReportController {


	private static final Logger logger = LoggerFactory.getLogger(MSATransBoundaryReportController.class);
	
	@Autowired
	MSAMasterReportService masterReportService;
	
	
	@Autowired
	MSATransactionalBoundaryService boundaryService;

	
	@GetMapping(value = "/transactioninfo")
	public ModelAndView getAllProjects(HttpServletRequest request) throws Exception {
 
		ModelAndView modelAndView = new ModelAndView("transactioninfo");
		modelAndView.addObject("projects", masterReportService.getAllProjects());
 
		return modelAndView;
	}
	
	@GetMapping(value = "/transactioninfo/{projectId}")
	public ModelAndView getAllJobs(HttpServletRequest request,@PathVariable String projectId) throws Exception {
 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("transactioninfo");
		modelAndView.addObject("jobs", masterReportService.getAllJobs(projectId));
 
		return modelAndView;
	}
	
	@PostMapping(value = "/transactionreport")
	public ModelAndView getTransactionalBoundaryAnalysis(@RequestParam String projectId) {
		System.out.println("Project ID for which transaction boundaries report is being pulled:"+projectId);
		ModelMap model = new ModelMap();
		if(null != projectId && !projectId.isEmpty()) {
			String[] projectInfo = projectId.split(":");
			if(projectInfo.length > 0) {
				//model.addAttribute("reports",boundaryService.getTransactionalBoundaryAnalysisReport(projectInfo[0],projectInfo[1]));
				model.addAttribute("projectId",projectInfo[0]);
				model.addAttribute("technology",projectInfo[1]);
				if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("ejb") < 0)) {
					return new ModelAndView("transactionreportEJB", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("spring") < 0)) {
					return new ModelAndView("transactionreportSpring", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("struts") < 0))  {
					return new ModelAndView("transactionreportStruts", model);
				}
				
			}
		}
		
		return new ModelAndView("genericError", model);
	}
	
	@GetMapping(value = "/transactionReportJSON")
	public ResponseEntity<String> getMicroServiceAnalysisJSON(@RequestParam("projectId")String projectId,@RequestParam("technology")String technology) {
		return boundaryService.getTransactionalBoundaryAnalysisReportJSON(projectId,technology);
	}
	
}
