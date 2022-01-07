package com.kuroshfarsimadan.demo29.model;

import java.util.Calendar;
import java.util.Date;


/**
 * @author Kurosh Farsi Madan
 *
 */
public class VerificationToken {

	public static int expiration = 60 * 24;
	
	private String confirmationToken;
	
	private String username;
	
	private Date expiryDate;

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
		VerificationToken.expiration = expiration;
	}

	/**
	 * @return the confirmationToken
	 */
	public String getConfirmationToken() {
		return confirmationToken;
	}

	/**
	 * @param confirmationToken the confirmationToken to set
	 */
	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
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
	
	public Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
		
		return calendar.getTime();
	}
}
