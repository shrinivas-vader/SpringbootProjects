package com.Springboot.security.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.security.Entity.AuthRequest;
import com.Springboot.security.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	
	public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	
	@PostMapping("/login")
	public String login(@RequestBody AuthRequest authData) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authData.getUsername(),
						authData.getPassword()
					)
				);
		return JwtService.generateToken(authentication.getName());
	}
}
