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

import com.kuroshfarsimadan.demo29.model.Password;
import com.kuroshfarsimadan.demo29.model.Registration;
import com.kuroshfarsimadan.demo29.model.ResetToken;
import com.kuroshfarsimadan.demo29.model.Roles;
import com.kuroshfarsimadan.demo29.model.UserDetails;
import com.kuroshfarsimadan.demo29.model.VerificationToken;
import com.kuroshfarsimadan.demo29.repository.PasswordRepository;
import com.kuroshfarsimadan.demo29.repository.RegistrationRepository;

/**
 * @author Kurosh Farsi Madan
 *
 */
@Service
public class PasswordServiceImpl implements PasswordService {

	@Autowired
	private PasswordRepository passwordRepository;
	
	@Override
	public void createResetToken(Password password, String token) {
		ResetToken resetToken = new ResetToken();
		resetToken.setToken(token);
		resetToken.setEmail(token);
		resetToken.setUsername(token);
		
		passwordRepository.saveToken(resetToken);
	}

	@Override
	public boolean confirmResetToken(ResetToken token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Password password, String username) {
		// TODO Auto-generated method stub
		
	}
	
	

}
