/**
 * 
 */
package com.kuroshfarsimadan.demo29.service;

import com.kuroshfarsimadan.demo29.model.Registration;

/**
 * @author Kurosh Farsi Madan
 *
 */
public interface RegistrationService {
	
	public Registration create (Registration registration);
	
	void createVerificationToken(Registration registration, String token);
	
	void confirmRegistration(String token);

}
