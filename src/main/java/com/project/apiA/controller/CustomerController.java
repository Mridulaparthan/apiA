package com.project.apiA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiA.schema.ApiAResponse;
import com.project.apiA.service.CustomerService;

@RestController
@RequestMapping("/customer-service/v1")		
public class CustomerController {

	@Autowired
	CustomerService service;
	@GetMapping()
	public String welcome()
	{
		return "welcome";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiAResponse> getLoansById(@PathVariable Integer id)
	{
		return new ResponseEntity<ApiAResponse>(service.getById(id),HttpStatus.OK);
	}
}
