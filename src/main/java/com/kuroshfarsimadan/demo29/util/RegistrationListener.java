package com.kuroshfarsimadan.demo29.util;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.kuroshfarsimadan.demo29.model.Registration;
import com.kuroshfarsimadan.demo29.service.RegistrationService;

// Event listener, bus-queue like behavior.
@Component
public class RegistrationListener implements ApplicationListener<OnCreateRegistrationEvent>{

	private String serverUrl = "http://localhost:8080";
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Override
	public void onApplicationEvent(OnCreateRegistrationEvent event) {
		
		this.confirmCreateRegistration(event);
	}

	private void confirmCreateRegistration(OnCreateRegistrationEvent event) {
		
		Registration registration = event.getRegistration();
		
		String registrationConfirmationToken = UUID.randomUUID().toString();
		
		registrationService.createVerificationToken(registration, registrationConfirmationToken);
		
		String userEmail = registration.getEmail();
		
		String subject = "Welcome to Acme. Your account has been successfully registered";
		// String url = event.getApplicationUrl() + "/accountConfirm?token=" + registrationConfirmationToken;
		String url = serverUrl + "/registrationConfirmation?token=" + registrationConfirmationToken;
		
		String body = "Registration confirmation link: " + url;
		
		SimpleMailMessage email = new SimpleMailMessage();
		
		email.setTo(userEmail);
		email.setSubject(subject);
		email.setText(body);
		
		mailSender.send(email);
	}

}
