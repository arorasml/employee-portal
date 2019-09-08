package com.myproject.employee;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.employee.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<List<Employee>> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/v1/getEmployees", HttpMethod.GET, entity,
				String.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void testGetSortedEmployees_Success() {
		HttpHeaders headers = new HttpHeaders();
		String sortByString = "name";
		HttpEntity<List<Employee>> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/v1/getSortedEmployees/?sortBy=" +sortByString, HttpMethod.GET, entity,
				String.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test()
	public void testGetSortedEmployees_Exception() {
		HttpHeaders headers = new HttpHeaders();
		String sortByString = "random";
		HttpEntity<List<Employee>> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/v1/getSortedEmployees/?sortBy=" +sortByString, HttpMethod.GET, entity,
				String.class);
		Assert.assertEquals(400, response.getStatusCodeValue());
	}
	
}
