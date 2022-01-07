/**
 * 
 */
package com.kuroshfarsimadan.demo29.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuroshfarsimadan.demo29.model.Password;
import com.kuroshfarsimadan.demo29.model.ResetToken;
import com.kuroshfarsimadan.demo29.repository.PasswordRepository;
import com.kuroshfarsimadan.demo29.service.PasswordService;
import com.kuroshfarsimadan.demo29.util.OnPasswordResetEvent;

/**
 * @author Kurosh Farsi Madan
 *
 */
@Controller
public class PasswordController {
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private PasswordRepository passwordRepository;
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private PasswordEncoder encoder;
		
	@GetMapping("password")
	public String getPasswordReset(@ModelAttribute("password") Password password) {
		return "password";
	}
	
	@PostMapping("password")
	public String sendEmailToReset(@Valid @ModelAttribute("password") Password password, BindingResult result) {
		
		eventPublisher.publishEvent(new OnPasswordResetEvent(password, ""));
		
		return "redirect:password?sent=true";
		
	}
	
	@GetMapping("passwordReset")
	public ModelAndView getNewPassword(@RequestParam("token") String token) {
		
		Password password = new Password();
		
		password.setToken(token);
		
		return new ModelAndView("passwordReset", "password", password);
		
	}
	
	@PostMapping("passwordReset")
	public String saveNewPassword(@RequestParam("token") String token, @ModelAttribute("password") Password password) {
		
		ResetToken resetToken = passwordRepository.findByToken(token);
		
		if(resetToken.getExpiryDate().after(new Date())) {
			password.setPassword(encoder.encode(password.getPassword()));
			passwordService.update(password, resetToken.getUsername());
			return "redirect:passwordReset?reset=true&token=0";
		} else {
			return "tokenExpired";
		}
	}
	

}
