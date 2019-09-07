package com.myproject.employee.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myproject.employee.entity.Employee;

/**
 * Repository class having crud 
 * operations implementation internally.
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

}
