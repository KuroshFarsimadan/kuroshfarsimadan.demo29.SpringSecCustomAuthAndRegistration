/**
 * 
 */
package com.kuroshfarsimadan.demo29.util;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.kuroshfarsimadan.demo29.model.Password;
import com.kuroshfarsimadan.demo29.service.PasswordService;

/**
 * @author Kurosh Farsi Madan
 *
 */
@Component
public class PasswordListener implements ApplicationListener<OnPasswordResetEvent> {

	private String serverUrl = "http://localhost:8080";
	
	@Autowired
	private JavaMailSender mailSender;
	private PasswordService passwordService;
	
	@Override
	public void onApplicationEvent(OnPasswordResetEvent event) {
		this.resetPassword(event);
		
	}

	private void resetPassword(OnPasswordResetEvent event) {
		
		Password password = event.getPassword();
		String token = UUID.randomUUID().toString();
		
		passwordService.createResetToken(password, token);
		
		String recipientAddress = password.getEmail();
		String subject = "Password reset";
		String confirmationUrl = event.getUrl() + "/passwordReset?token=" + token;
		String message = "Password reset token: " + confirmationUrl;
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(token);
		email.setSubject(subject);
		email.setText(message);
		mailSender.send(email);
		
	}

}
