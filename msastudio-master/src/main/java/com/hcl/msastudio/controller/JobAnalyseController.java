package com.hcl.msastudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msastudio.domain.ProjectDTO;
import com.hcl.msastudio.service.JobAnalyseService;
import com.hcl.msastudio.service.SecurityService;


@RestController
public class JobAnalyseController {
	
	@Autowired
	JobAnalyseService jobAnalyseService;

    @Autowired
    private SecurityService securityService;

	@GetMapping(value = "/completedjob")
	public ModelAndView getAllCompletedJobs() throws Exception {

		ModelAndView modelAndView = new ModelAndView("completedjob");
		modelAndView.addObject("jobs", jobAnalyseService.getAllJobs());

		return modelAndView;
	
	}
	@GetMapping(value = "/scheduledjob")
	public ModelAndView getAllScheduledJobs() throws Exception {
		String loggedInUser=securityService.findLoggedInUsername();
		ModelAndView modelAndView = new ModelAndView("scheduledjob");
		modelAndView.addObject("jobs", jobAnalyseService.getAllJobs());

		return modelAndView;
	
	}
}
