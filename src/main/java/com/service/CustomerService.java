package com.service;

import java.util.List;

import com.model.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);

	public String getCurrentUser();

	public Customer getCustomer();

	public int updateCustomer(Customer customer);
}
