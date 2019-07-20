package com.hcl.msastudio.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hcl.msastudio.model.User;
import com.hcl.msastudio.service.SecurityService;
import com.hcl.msastudio.service.UserService;
import com.hcl.msastudio.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@SessionAttributes("loggedInUser")
public class MSALoginController {
	private static final Logger logger = LoggerFactory.getLogger(MSALoginController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        logger.debug("INSIDE LoginController Registration GET");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
         logger.debug("INSIDE LoginController Registration POST");
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        model.addAttribute("loggedInUser", userForm.getUsername());
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    	 logger.info("INSIDE LoginController login");
    	String loggedInUser=securityService.findLoggedInUsername();
    	if(loggedInUser!=null)
    		model.addAttribute("loggedInUser", loggedInUser);
    	else {
    		model.addAttribute("loggedInUser", "");
    	}
        if (error != null) {
            model.addAttribute("error", "Your username or password is invalid.");
        }
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "login";
    }
   
}
