package com.consulta.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.consulta.service.implementation.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Value("${security.signing-key}")
	private String signingKey;

	@Value("${security.encoding-strength}")
	private Integer encodingStrength;

	@Value("${security.security-realm}")
	private String securityRealm;

	@Autowired
	private DataSource dataSource;	
		
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEnconder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();		
		return bCryptPasswordEncoder;
	}
	
	@Bean
	public CustomUserDetailsService userDetailsService() {	    
		
		return new CustomUserDetailsService();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChainAuthEndPoints(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((auth2) -> auth2
			.requestMatchers("/usuarios")
			.permitAll()
			.anyRequest()
			.authenticated());
		return http.build();
	}
	
	
	@Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
        return authenticationManagerBuilder.build();
    }
		
	
}
