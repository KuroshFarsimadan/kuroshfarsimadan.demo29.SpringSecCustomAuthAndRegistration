package com.kuroshfarsimadan.demo29.repository;

import com.kuroshfarsimadan.demo29.model.Registration;
import com.kuroshfarsimadan.demo29.model.UserDetails;
import com.kuroshfarsimadan.demo29.model.VerificationToken;

public interface RegistrationRepository {
	public Registration create (Registration registration);

	public void saveToken(VerificationToken verificationToken);

	public VerificationToken findByToken(String token);

	public Registration findByUsername(String username);

	public void createUserDetails(UserDetails userDetails);

	public void createRoles(UserDetails userDetails);

	public void delete(Registration registration);

	public void deleteToken(String token);
}
