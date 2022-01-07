package com.kuroshfarsimadan.demo29.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuroshfarsimadan.demo29.model.Registration;
import com.kuroshfarsimadan.demo29.service.RegistrationService;
import com.kuroshfarsimadan.demo29.util.OnCreateRegistrationEvent;

import javax.validation.Valid;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	
    @GetMapping("registration")
    public String getRegistration(@ModelAttribute ("registration") Registration registration) {
        return "registration";
    }

    @PostMapping("registration")
    // @Secured("ROLE_USER") user does not have a role before registering. Add user role check in a separate controller for checking signed
    // in user details as a TODO
    public String addRegistration(@Valid @ModelAttribute ("registration")
                                              Registration registration,
                                  BindingResult result,
                                  Authentication auth) {
        if(result.hasErrors()) {
            return "registration";
        }
        
        registration.setPassword(passwordEncoder.encode(registration.getPassword()));
        
        registration = registrationService.create(registration);
        
        eventPublisher.publishEvent(new OnCreateRegistrationEvent(registration, "test"));

        return "redirect:registration";
    }
    
    @GetMapping("registrationConfirmation")
    public String registrationConfirmation(@RequestParam("token") String token) {
    	registrationService.confirmRegistration(token);
		return "registrationConfirmed";
    	
    }

}
