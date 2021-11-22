package com.project.apiA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.apiA.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{
	
	
}
