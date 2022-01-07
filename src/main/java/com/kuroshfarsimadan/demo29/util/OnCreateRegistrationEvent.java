/**
 * 
 */
package com.kuroshfarsimadan.demo29.util;

import org.springframework.context.ApplicationEvent;

import com.kuroshfarsimadan.demo29.model.Registration;

/**
 * @author Kurosh Farsi Madan
 *
 */
@SuppressWarnings("serial")
public class OnCreateRegistrationEvent extends ApplicationEvent {

	/*
	 * Change version when code changes 
	 */

	private String applicationUrl;
	private Registration registration;
	
	
	public OnCreateRegistrationEvent(Registration reg, String url) {
		super(reg);
		
		this.registration = reg;
		this.applicationUrl = url;
		
	}


	/**
	 * @return the applicationUrl
	 */
	public String getApplicationUrl() {
		return applicationUrl;
	}


	/**
	 * @param applicationUrl the applicationUrl to set
	 */
	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}


	/**
	 * @return the registration
	 */
	public Registration getRegistration() {
		return registration;
	}


	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
	
	

}
