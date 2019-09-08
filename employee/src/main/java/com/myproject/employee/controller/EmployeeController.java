package com.myproject.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.employee.common.RequestParamsEnum;
import com.myproject.employee.common.exception.ParameterNotValidException;
import com.myproject.employee.entity.Employee;
import com.myproject.employee.service.EmployeeService;

/**
 * Main controller class mapped with client url request.
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
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam(value = "sortBy") String sortBy) {
		if (!RequestParamsEnum.getValues().contains(sortBy))
		{
			throw new ParameterNotValidException();
		}
		return ResponseEntity.ok().body(service.getEmployees(sortBy));
	}

}
