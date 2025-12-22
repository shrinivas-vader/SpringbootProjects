package com.Springboot.security.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityService {
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	    return config.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/public/**").permitAll()
					.requestMatchers("/admin/**").hasAllRoles("ADMIN")
					.requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
					.anyRequest().authenticated()
				)
			.httpBasic(Customizer.withDefaults());
		
		
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
		
		UserDetails user = User.withUsername("user")
				.password(encoder.encode("user123"))
				.roles("USER")
				.build();
		
		UserDetails admin = User.withUsername("admin")
				.password(encoder.encode("admin123"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
