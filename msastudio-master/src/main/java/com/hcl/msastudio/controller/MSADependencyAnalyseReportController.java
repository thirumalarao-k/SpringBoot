package com.hcl.msastudio.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msastudio.domain.ProjectDTO;
import com.hcl.msastudio.service.MSADataModelReportService;
import com.hcl.msastudio.service.MSADependencyService;
import com.hcl.msastudio.service.MSAMasterReportService;

@RestController
public class MSADependencyAnalyseReportController {

	private static final Logger logger = LoggerFactory.getLogger(MSADependencyAnalyseReportController.class);
	
	@Autowired
	MSAMasterReportService masterReportService;
	
	@Autowired
	MSADependencyService dependencyService;

	@GetMapping(value = "/dependency")
	public ModelAndView getAllProjects(@ModelAttribute("ProjectDTO") ProjectDTO user,
		      BindingResult result, Model model) throws Exception {

		ModelAndView modelAndView = new ModelAndView("dependency");
		//modelAndView.setViewName(request.getServletPath().substring(1));
		modelAndView.addObject("projects", masterReportService.getAllProjects());

		return modelAndView;
	}

/*	@GetMapping(value = "/dependency/{projectId}")
	public ModelAndView getAllJobs(HttpServletRequest request, @PathVariable String projectId) throws Exception {

		ModelAndView modelAndView = new ModelAndView("dependency");
		modelAndView.addObject("jobs", masterReportService.getAllJobs(projectId));

		return modelAndView;
	}*/

	@PostMapping(value = "/dependencyreport")
	public ModelAndView getDependencyAnalysis(@RequestParam String projectId) {
		ModelMap model = new ModelMap();
		if(null != projectId && !projectId.isEmpty()) {
			String[] projectInfo = projectId.split(":");
			if(projectInfo.length > 0) {
				//model.addAttribute("reports", dependencyService.getDependencyAnalysisReport(projectInfo[0]));
				model.addAttribute("projectId",projectInfo[0]);
				model.addAttribute("technology",projectInfo[1]);
				if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("ejb") < 0)) {
					return new ModelAndView("dependencyreportEJB", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("spring") < 0)) {
					return new ModelAndView("dependencyreportSpring", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("struts") < 0))  {
					return new ModelAndView("dependencyreportStruts", model);
				}
			}
				
		}
		return new ModelAndView("genericError", model);
	}
	
	@GetMapping(value = "/dependencyReportJSON")
	public ResponseEntity<String> getMicroServiceAnalysisJSON(@RequestParam("projectId")String projectId,@RequestParam("technology")String technology) {
		return dependencyService.getDependencyAnalysisReportJSON(projectId,technology);
	}
}
