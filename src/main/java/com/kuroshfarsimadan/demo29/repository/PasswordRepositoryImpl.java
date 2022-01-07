/**
 * 
 */
package com.kuroshfarsimadan.demo29.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kuroshfarsimadan.demo29.model.Password;
import com.kuroshfarsimadan.demo29.model.ResetToken;
import com.kuroshfarsimadan.demo29.model.VerificationToken;

/**
 * @author Kurosh Farsi Madan
 *
 */
@Repository
public class PasswordRepositoryImpl implements PasswordRepository {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void saveToken(ResetToken resetToken) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		template.update("INSERT INTO reset_tokens (email, username, token, expiry_date) VALUES (?, ?, ?, ?)", 
				resetToken.getEmail(),
				resetToken.getUsername(),
				resetToken.getToken(),
				resetToken.calculateExpiryDate(resetToken.expiration)
				);
		
	}

	@Override
	public ResetToken findByToken(String token) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		ResetToken resetToken = 
		template.queryForObject("SELECT email, username, token, expiry_date from reset_tokens where token = ?", 
					new RowMapper<ResetToken>() {

						@Override
						public ResetToken mapRow(ResultSet rs, int rowNum) throws SQLException {
							ResetToken rsToken = new ResetToken();
							rsToken.setEmail(rs.getString("email"));
							rsToken.setUsername(rs.getString("username"));
							rsToken.setToken(rs.getString("token"));
							rsToken.setExpiryDate(rs.getTimestamp("expiry_date"));
							return rsToken;
						}
			
				}, token
				);
		return resetToken;
	}

	@Override
	public void update(Password password, String username) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		template.update("UPDATE users SET password = ? WHERE username = ?", password.getPassword(), username);
	}

}
