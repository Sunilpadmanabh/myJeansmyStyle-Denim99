package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);

	int updateCustomer(Customer customer);
	
	void deleteCustomer(String email);

}
