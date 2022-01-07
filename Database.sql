CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  firstName VARCHAR(100) NOT NULL,
  lastName VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);
CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);
  
  
INSERT INTO users (username, password, enabled)
  values ('kuroshfarsimadan',
    '$2a$10$Bxg3iOBWFf1a3XVGdb5L2.ccJb7ecMjiMRV22l0Ggotv9eAPAoDXm',
    1);
 
INSERT INTO authorities (username, authority)
  values ('kuroshfarsimadan', 'ROLE_USER');

CREATE TABLE persistent_logins (
  	username VARCHAR(50) NOT NULL,
  	series VARCHAR(64) PRIMARY KEY,
  	token VARCHAR(64) NOT NULL,
  	last_used TIMESTAMP NOT NULL,
  	FOREIGN KEY (username) REFERENCES users(username)  
);

CREATE TABLE verification_tokens (
  	username VARCHAR(150) NOT NULL,
  	token VARCHAR(150) NOT NULL,
  	expiry_date DATETIME NOT NULL,
  	PRIMARY KEY (username, token)
);

CREATE TABLE reset_tokens (
	username VARCHAR(50) NOT NULL,

  	email VARCHAR(100) NOT NULL,
	
  	token VARCHAR(100) NOT NULL,
  	
  	expiry_date DATETIME NOT NULL,
  	
  	PRIMARY KEY(email, token)
);


  
  
 