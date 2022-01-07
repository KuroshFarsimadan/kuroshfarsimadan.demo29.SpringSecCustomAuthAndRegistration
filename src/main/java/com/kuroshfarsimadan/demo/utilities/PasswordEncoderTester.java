package com.kuroshfarsimadan.demo.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Kurosh Farsi Madan
 *
 */
public class PasswordEncoderTester {

	  public static void main(String[] args) {

			String password = "password";
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
	
	  }
}