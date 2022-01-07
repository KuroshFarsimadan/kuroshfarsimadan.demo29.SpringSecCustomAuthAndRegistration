/**
 * 
 */
package com.kuroshfarsimadan.demo29.repository;

import com.kuroshfarsimadan.demo29.model.Password;
import com.kuroshfarsimadan.demo29.model.ResetToken;

/**
 * @author Kurosh Farsi Madan
 *
 */
public interface PasswordRepository {
	
	void saveToken(ResetToken resetToken);
	
	ResetToken findByToken(String token);
	
	void update(Password password, String username);

}
