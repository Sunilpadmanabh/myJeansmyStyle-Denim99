package com.dao;

import com.model.CustomerWithoutLogin;

public interface CustomerWithoutLoginDao {

	public CustomerWithoutLogin getCustomerWithoutLogin(String customerId);

	public void saveCustomerWithoutLogin(CustomerWithoutLogin customerWithoutLogin);

}
