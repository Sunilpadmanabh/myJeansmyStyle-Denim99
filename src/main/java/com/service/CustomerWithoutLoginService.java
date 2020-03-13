package com.service;

import java.util.List;

import com.model.CartItemWithoutLogin;
import com.model.CustomerWithoutLogin;

public interface CustomerWithoutLoginService {

	public CustomerWithoutLogin getCustomerWithoutLogin(String customerId);
	
	public void saveCustomerWithoutLogin(CustomerWithoutLogin customerWithoutLogin);

	public double calculateGrandTotal(List<CartItemWithoutLogin> cartItemWithoutLogin);
}
