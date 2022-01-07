package com.kuroshfarsimadan.demo29.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kuroshfarsimadan.demo29.model.Registration;
import com.kuroshfarsimadan.demo29.model.User;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexEmpty (Principal principal, Model model) {
 
    	if(principal != null) {
    		model.addAttribute("message", principal.getName());

    	}

        return "index";
    }
    
    @GetMapping("index")
    public String index (Principal principal, Model model, Authentication auth) {
    	if (principal != null) {
    		model.addAttribute("message", principal.getName());
    	}
		
        return "index";
    }

}
