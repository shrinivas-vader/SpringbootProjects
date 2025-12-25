package com.Springboot.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Springboot.security.Entity.Employee;
import com.Springboot.security.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;
	
	public String addEmployee(Employee employeeData) {
		Employee employee = new Employee();
		employee.setEmp_name(employeeData.getEmp_name());
		employee.setEmp_salary(employeeData.getEmp_salary());
		employeeRepository.save(employee);
		return "Employee added successfully";
	}
	
	
	
	Pageable pageable = PageRequest.of(0, 6);
	
	
	public List<Employee> getAllEmp(){
		return employeeRepository.findAll(pageable).getContent();
	}
}
