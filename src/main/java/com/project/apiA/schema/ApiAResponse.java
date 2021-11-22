package com.project.apiA.schema;

import java.util.List;

public class ApiAResponse {

	Integer id;
	String name;
	List<Loan> loans;
	String message;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public void setMessage(String message) {
		this.message= message;
		
	}
	public String getMessage() {
		return message;
	}
	
}
