package com.Springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user/sayhello")
	public String sayHello() {
		return "Hello. This is from user Controller. User/Admin can access";
	}
}
