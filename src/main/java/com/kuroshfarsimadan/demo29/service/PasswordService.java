/**
 * 
 */
package com.kuroshfarsimadan.demo29.service;

import com.kuroshfarsimadan.demo29.model.Password;
import com.kuroshfarsimadan.demo29.model.ResetToken;

/**
 * @author Kurosh Farsi Madan
 *
 */
public interface PasswordService {
	
	void createResetToken(Password password, String token);
	
	boolean confirmResetToken(ResetToken token);
	
	void update(Password password, String username);
}
