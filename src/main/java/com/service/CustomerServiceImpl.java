package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CustomerDao;
import com.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	// The database transaction happens inside the scope of a persistence
	// context. The persistence context is in JPA the EntityManager ,
	// implemented internally using an Hibernate Session (when using Hibernate
	// as the persistence provider).

	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	public List<Customer> getAllCustomers() {

		return customerDao.getAllCustomers();
	}

	public Customer getCustomerByemailId(String emailId) {
		return customerDao.getCustomerByemailId(emailId);
	}

	public int updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	public String getCurrentUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		Customer customer = customerDao.getCustomerByemailId(emailId);
		return customer.getFirstName();
	}

	public Customer getCustomer() {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String emailId = user.getUsername();
			Customer customer = customerDao.getCustomerByemailId(emailId);
			return customer;
		}
		Customer c=new Customer();
		c.setFirstName(" ");
		return c;
	}
}
