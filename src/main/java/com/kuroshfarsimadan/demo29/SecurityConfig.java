package com.kuroshfarsimadan.demo29;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * @author Kurosh Farsi Madan
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (
	prePostEnabled = true, 
	securedEnabled = true,
	jsr250Enabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/").permitAll() // Home screen URL
                .antMatchers("/index*").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/registration*").permitAll()
                .antMatchers("/password*").permitAll()
                .antMatchers("/assets/css/**", "assets/js/**", "/images/**").permitAll()
                .anyRequest().authenticated()          
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .failureUrl("/login?error=true")
                .permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .rememberMe()
                .key("awd3553hu4234u&I@$$$#eefsefesf45464EJGYWAHDUJO88887777WAPIHWCBNX&737310&)(@!!)-!_!$(*_!(@$@5OAWIJ234")
                .tokenRepository(tokenRepository())
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                 //.logoutUrl("logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/perform_logout", "GET"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();

    }   

    @Bean
    public PersistentTokenRepository tokenRepository () {
    	JdbcTokenRepositoryImpl token = new JdbcTokenRepositoryImpl();
    	token.setDataSource(dataSource);
    	return token;
    }
    
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication()
        //        .withUser("bryan").password(passwordEncoder().encode("pass")).roles("USER");
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
