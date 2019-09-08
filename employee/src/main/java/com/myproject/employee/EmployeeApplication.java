package com.myproject.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myproject.employee.dto.EmployeeDTO;
import com.myproject.employee.service.EmployeeService;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

	@Autowired
	EmployeeService service;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		createAndSaveSampleEmployeeList();
	}

	void createAndSaveSampleEmployeeList() {
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		EmployeeDTO e1 = new EmployeeDTO("himanshu", 30, 100);
		EmployeeDTO e2 = new EmployeeDTO("arora", 50, 1000);
		EmployeeDTO e3 = new EmployeeDTO("rahul", 80, 10000);
		employeeDTOs.add(e1);
		employeeDTOs.add(e2);
		employeeDTOs.add(e3);
		employeeDTOs.stream().forEach(x -> service.add(x));

	}

}
