package com.example.tattoC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		return new InMemoryUserDetailsManager(
		 User.withUsername("jordy")
		        .password(passwordEncoder.encode("012890"))
		        .build(),
		 User.withUsername("cystal")
		        .password(passwordEncoder.encode("012890"))
		        .build()
				);
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.httpBasic()
				.and()
				.authorizeRequests()
				.requestMatchers("/inicio").permitAll()
				.requestMatchers("/ad").authenticated()
				.and().build();    
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {	
		
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
	}
}
