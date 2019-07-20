package com.hcl.msastudio.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msastudio.domain.ProjectDTO;
import com.hcl.msastudio.service.MSADataModelReportService;
import com.hcl.msastudio.service.MSAMasterReportService;

@RestController
public class MSADataModelReportController {

	private static final Logger logger = LoggerFactory.getLogger(MSADataModelReportController.class);
	
	@Autowired
	MSAMasterReportService masterReportService;
	
	@Autowired
	MSADataModelReportService dataModelReportService;

	@GetMapping(value = "/datamodel")
	public ModelAndView getAllProjects(@ModelAttribute("ProjectDTO") ProjectDTO user,
		      BindingResult result, Model model) throws Exception {

		ModelAndView modelAndView = new ModelAndView("datamodel");
		//modelAndView.setViewName(request.getServletPath().substring(1));
		modelAndView.addObject("projects", masterReportService.getAllProjects());

		return modelAndView;
	}

	@PostMapping(value = "/datamodelreport")
	public ModelAndView getDataModelAnalysis(@RequestParam String projectId) {
		ModelMap model = new ModelMap();
		if(null != projectId && !projectId.isEmpty()) {
			String[] projectInfo = projectId.split(":");
			if(projectInfo.length > 0) {
				//model.addAttribute("reports",dataModelReportService.getDataModelAnalysisReport(projectInfo[0],projectInfo[1]));
				model.addAttribute("projectId",projectInfo[0]);
				model.addAttribute("technology",projectInfo[1]);
				if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("ejb") < 0)) {
					return new ModelAndView("datamodelreportEJB", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("spring") < 0)) {
					return new ModelAndView("datamodelreportSpring", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("struts") < 0))  {
					return new ModelAndView("datamodelreportStruts", model);
				}
				
			}
		}
		
		return new ModelAndView("genericError", model);
	}
	
	@GetMapping(value = "/dataModelReportJSON")
	public ResponseEntity<String> getMicroServiceAnalysisJSON(@RequestParam("projectId")String projectId,@RequestParam("technology")String technology) {
		return dataModelReportService.getDataModelAnalysisReportAsJSON(projectId, technology);
	}
}
