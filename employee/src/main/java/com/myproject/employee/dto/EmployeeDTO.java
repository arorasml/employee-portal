package com.myproject.employee.dto;

import javax.validation.constraints.NotNull;

public class EmployeeDTO {
	
	public EmployeeDTO(@NotNull String name, @NotNull int age, @NotNull int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@NotNull
	private String name;
	@NotNull
	private int age;
	@NotNull
	private int salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
