/**
 * 
 */
package com.kuroshfarsimadan.demo29.model;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Kurosh Farsi Madan
 *
 */
public class ResetToken {
	
	public static int expiration = 60 * 24;
	
	private String token;
	private String email;
	private Date expiryDate;
	private String username;
	
	/**
	 * @return the expiration
	 */
	public static int getExpiration() {
		return expiration;
	}
	/**
	 * @param expiration the expiration to set
	 */
	public static void setExpiration(int expiration) {
		ResetToken.expiration = expiration;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
		
		return calendar.getTime();
	}
	
}
