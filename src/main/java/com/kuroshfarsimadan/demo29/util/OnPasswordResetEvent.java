/**
 * 
 */
package com.kuroshfarsimadan.demo29.util;

import javax.validation.Valid;

import org.springframework.context.ApplicationEvent;

import com.kuroshfarsimadan.demo29.model.Password;

/**
 * @author Dell
 *
 */
@SuppressWarnings("serial")
public class OnPasswordResetEvent extends ApplicationEvent {
	
	private String url;
	private Password password;

	public OnPasswordResetEvent(@Valid Password password, String url) {
		super(password);
		this.url = url; 
		this.password = password;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the password
	 */
	public Password getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(Password password) {
		this.password = password;
	}


	

}
