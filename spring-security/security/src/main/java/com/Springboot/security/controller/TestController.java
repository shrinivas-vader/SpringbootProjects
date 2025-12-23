package com.Springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello. This is authenticated";
	}
	
	@GetMapping("/public/hello")
	public String hello() {
		return "hello. This is public URL. No autentication required";
	}
}
