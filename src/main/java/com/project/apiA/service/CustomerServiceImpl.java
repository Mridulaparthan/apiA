package com.project.apiA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.apiA.model.Customer;
import com.project.apiA.repo.CustomerRepo;
import com.project.apiA.schema.ApiAResponse;
import com.project.apiA.schema.ApiBResponse;
import com.project.apiA.schema.Loan;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo repo;
    
    @Autowired
    WebClient.Builder webClient;
    
	public ApiAResponse getById(Integer id) {
	    ApiAResponse response=new ApiAResponse();
		Optional<Customer> optCustomer=repo.findById(id);
	    if(optCustomer.isPresent()) {
	    	response.setId(optCustomer.get().getId());
	    	response.setName(optCustomer.get().getName());
	    	try {
	    	ApiBResponse apiBResponse=webClient.build().get().uri("49.37.181.189:8001/loan-service/v1/customer/{id}/loans",id).retrieve().
	    			bodyToMono(ApiBResponse.class).block();
	    	response.setLoans(apiBResponse.getLoan());
	    	response.setMessage("customer details fetched successfully");
	
	    	}
	    	catch(Exception e){
	    		response.setLoans(null);
	    		response.setMessage("apiB down");
	    	}
	    	return response;
	    }
	    response.setMessage("customerId not valid");
		return response;
	}

}
