/**
 * 
 */
package com.kuroshfarsimadan.demo29.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import com.kuroshfarsimadan.demo29.model.Registration;
import com.kuroshfarsimadan.demo29.model.UserDetails;
import com.kuroshfarsimadan.demo29.model.VerificationToken;

/**
 * @author Kurosh Farsi Madan
 *
 */
@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {

	/*
	 * TODO: The SQL statements can be SQL files and referenced here
	 * 
	 */
	@Autowired
	private DataSource dataSource;
	
	@Override
	public Registration create(Registration registration) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		template.update("INSERT INTO users (username, password, email, firstName, lastName, name, enabled) VALUES (?, ?, ?, ?, ?, '', 0)", 
				registration.getUsername(),
				registration.getPassword(),
				registration.getEmail(),
				registration.getFirstName(),
				registration.getLastName()				
				);
		
		return registration;
	}

	@Override
	public void saveToken(VerificationToken verificationToken) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		template.update("INSERT INTO verification_tokens (username, token, expiry_date) VALUES (?, ?, ?)", 
				verificationToken.getUsername(),
				verificationToken.getConfirmationToken(),
				verificationToken.calculateExpiryDate(verificationToken.expiration)
				);
		
	}

	@Override
	public VerificationToken findByToken(String token) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		VerificationToken verificationToken = 
		template.queryForObject("SELECT username, token, expiry_date from verification_tokens where token = ?", 
					new RowMapper<VerificationToken>() {

						@Override
						public VerificationToken mapRow(ResultSet rs, int rowNum) throws SQLException {
							VerificationToken vrToken = new VerificationToken();
							vrToken.setUsername(rs.getString("username"));
							vrToken.setConfirmationToken(rs.getString("token"));
							vrToken.setExpiryDate(rs.getTimestamp("expiry_date"));
							return vrToken;
						}
			
				}, token
				);
		return verificationToken;
	}

	@Override
	public Registration findByUsername(String username) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		Registration registration = 
		template.queryForObject("SELECT username, firstname, lastname, password from users where username = ?", 
					new RowMapper<Registration>() {

						@Override
						public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
							Registration registration = new Registration();
							registration.setUsername(rs.getString("username"));
							registration.setFirstName(rs.getString("firstname"));
							registration.setLastName(rs.getString("lastname"));
							registration.setPassword(rs.getString("password"));
							return registration;
						}
			
				}, username
				);
		return registration;
	}

	@Override
	public void createUserDetails(UserDetails userDetails) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		template.update("UPDATE users SET Enabled = 1 where username = ?", userDetails.getUsername());
		
		/*
		template.update("INSERT INTO users (name, username, password, enabled) VALUES ('', ?, ?, ?)", 
				userDetails.getUsername(),
				userDetails.getPassword(),
				1
				); */
	}

	@Override
	public void createRoles(UserDetails userDetails) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		Iterator<GrantedAuthority> iterator = userDetails.getAuthorities().iterator();
		
		while(iterator.hasNext()) {
			template.update("INSERT INTO authorities(username, authority) VALUES (?, ?)",
			userDetails.getUsername(),
			iterator.next().getAuthority());
		}
		
		
	}

	@Override
	public void delete(Registration registration) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		template.update("DELETE FROM users where username = ?", registration.getUsername());
	}

	@Override
	public void deleteToken(String token) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		template.update("DELETE FROM verification_tokens where token = ?", token);
	}
	
}
