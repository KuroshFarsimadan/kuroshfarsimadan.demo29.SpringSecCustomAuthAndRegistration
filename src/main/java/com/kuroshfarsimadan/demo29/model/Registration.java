package com.kuroshfarsimadan.demo29.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Kurosh Farsi Madan
 *
 */
public class Registration {

	@NotNull
    @NotEmpty
    private String username;
	
	@NotNull
    @NotEmpty
    private String firstName;
	
	@NotNull
    @NotEmpty
    private String lastName;
	
	@NotNull
    @NotEmpty
    private String password;
	
	@NotNull
    @NotEmpty
    private String matchingPassword;
	
	@NotNull
    @NotEmpty
    private String email;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the matchingPassword
	 */
	public String getMatchingPassword() {
		return matchingPassword;
	}

	/**
	 * @param matchingPassword the matchingPassword to set
	 */
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
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
	
	

}
