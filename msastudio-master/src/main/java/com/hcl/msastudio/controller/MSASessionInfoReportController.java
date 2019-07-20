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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msastudio.service.MSAMasterReportService;
import com.hcl.msastudio.service.MSASessionInfoReportService;



@RestController
public class MSASessionInfoReportController {

	private static final Logger logger = LoggerFactory.getLogger(MSASessionInfoReportController.class);
	
	@Autowired
	MSAMasterReportService masterReportService;
	
	@Autowired
	MSASessionInfoReportService sessionInfoReportService;

	@GetMapping(value = "/sessioninfo")
	public ModelAndView getAllProjects(HttpServletRequest request) throws Exception {

		ModelAndView modelAndView = new ModelAndView("sessioninfo");
		modelAndView.addObject("projects", masterReportService.getAllProjects());
		return modelAndView;
	}

	@PostMapping(value = "/sessiondetailreport")
	public ModelAndView getSessionDetailsAnalysis(@RequestParam("projectId")String projectId) {
		ModelMap model = new ModelMap();
		if(null != projectId && !projectId.isEmpty()) {
			String[] projectInfo = projectId.split(":");
			if(projectInfo.length > 0) {
				//model.addAttribute("reports",sessionInfoReportService.getSessionDetailsAnalysisReport(projectInfo[0],projectInfo[1]));
				model.addAttribute("projectId",projectInfo[0]);
				model.addAttribute("technology",projectInfo[1]);
				if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("ejb") < 0)) {
					return new ModelAndView("sessiondetailreportEJB", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("spring") < 0)) {
					return new ModelAndView("sessiondetailreportSpring", model);
				}else if(null != projectInfo[1] && !(projectInfo[1].toLowerCase().indexOf("struts") < 0))  {
					return new ModelAndView("sessiondetailreportStruts", model);
				}
			}
		}
		return new ModelAndView("genericError", model);

	}
	
	@GetMapping(value = "/sessiondetailReportJSON")
	public ResponseEntity<String> getMicroServiceAnalysisJSON(@RequestParam("projectId")String projectId,@RequestParam("technology")String technology) {
		return sessionInfoReportService.getSessionDetailsAnalysisReportAsJSON(projectId,technology);
	}

}
