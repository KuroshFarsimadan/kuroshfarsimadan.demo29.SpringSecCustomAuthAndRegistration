/**
 * 
 */
package com.kuroshfarsimadan.demo29.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.kuroshfarsimadan.demo29.model.Registration;
import com.kuroshfarsimadan.demo29.model.Roles;
import com.kuroshfarsimadan.demo29.model.UserDetails;
import com.kuroshfarsimadan.demo29.model.VerificationToken;
import com.kuroshfarsimadan.demo29.repository.RegistrationRepository;

/**
 * @author Kurosh Farsi Madan
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public Registration create(Registration registration) {
		return registrationRepository.create(registration);
	}

	@Override
	public void createVerificationToken(Registration registration, String token) {
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setConfirmationToken(token);
		verificationToken.setUsername(registration.getUsername());
		
		registrationRepository.saveToken(verificationToken);
		
	}

	@Override
	public void confirmRegistration(String token) {
		VerificationToken verificationToken = registrationRepository.findByToken(token);
		
		if(verificationToken.getExpiryDate().after(new Date())) {
			Registration registration = registrationRepository.findByUsername(verificationToken.getUsername());
			
			List<GrantedAuthority> roles = new ArrayList<>();
			
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			UserDetails userDetails = new UserDetails(
					registration.getUsername(),
					registration.getPassword(),
					roles
					);
			
			registrationRepository.createUserDetails(userDetails);
			
			registrationRepository.createRoles(userDetails);
			
			// registrationRepository.delete(registration);
			
			registrationRepository.deleteToken(token);
			
		}
		
	}
	

}
