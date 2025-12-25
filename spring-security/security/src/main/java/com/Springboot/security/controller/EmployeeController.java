package com.Springboot.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.security.Entity.Employee;
import com.Springboot.security.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employees) {
		return employeeservice.addEmployee(employees);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployees(){
		return employeeservice.getAllEmp();
	}
}
