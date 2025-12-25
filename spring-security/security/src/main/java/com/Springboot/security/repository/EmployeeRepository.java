package com.Springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springboot.security.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
