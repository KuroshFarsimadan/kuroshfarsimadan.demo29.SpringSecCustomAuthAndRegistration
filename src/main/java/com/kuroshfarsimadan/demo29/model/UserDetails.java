/**
 * 
 */
package com.kuroshfarsimadan.demo29.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Kurosh Farsi Madan
 *
 */
@SuppressWarnings("serial")
public class UserDetails extends org.springframework.security.core.userdetails.User {

	/*
	 * Change version when changed
	 */
	private String name;
	
	public UserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	public UserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
