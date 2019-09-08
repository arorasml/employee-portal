package com.myproject.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.employee.dto.EmployeeDTO;
import com.myproject.employee.entity.Employee;
import com.myproject.employee.service.EmployeeService;

/**
 * Main controller class
 * mapped with client url
 * request.
 */
@RestController
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return service.getEmployees();
	}
	
	@GetMapping("/getSortedEmployees")
	public List<Employee> getEmployees(@RequestParam(value = "sortBy",defaultValue= "") String sortBy) {
		return service.getEmployees(sortBy);
	}

}
