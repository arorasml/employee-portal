package com.myproject.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myproject.employee.dto.EmployeeDTO;
import com.myproject.employee.entity.Employee;
import com.myproject.employee.repository.EmployeeRepository;

/**
 * Service class having 
 * methods for crud operation.
 */
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public void add(EmployeeDTO dto) {
		repository.save(toEntity(dto));
	}

	public List<Employee> getEmployees() {

		return (List<Employee>) repository.findAll();
	}

	public List<Employee> getEmployees(String sortBy) {
		Sort sort = Sort.by(sortBy);
		return (List<Employee>) repository.findAll(sort);
	}

	private Employee toEntity(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setSalary(dto.getSalary());
		return entity;
	}

}
