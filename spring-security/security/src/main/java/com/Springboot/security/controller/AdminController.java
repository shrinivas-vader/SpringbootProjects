package com.Springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@GetMapping("/admin/sayhello")
	public String sayHello() {
		return "Hello. This is from Admin controller. Only admin can access.";
	}
}
