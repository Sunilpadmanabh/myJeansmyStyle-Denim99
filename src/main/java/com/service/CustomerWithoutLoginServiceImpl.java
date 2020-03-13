package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerWithoutLoginDao;
import com.model.CartItemWithoutLogin;
import com.model.CustomerWithoutLogin;

@Service
public class CustomerWithoutLoginServiceImpl implements CustomerWithoutLoginService{

	@Autowired
	private CustomerWithoutLoginDao customerWithoutLoginDao;

	public CustomerWithoutLoginDao getCustomerWithoutLoginDao() {
		return customerWithoutLoginDao;
	}

	public void setCustomerWithoutLoginDao(CustomerWithoutLoginDao customerWithoutLoginDao) {
		this.customerWithoutLoginDao = customerWithoutLoginDao;
	}

	public CustomerWithoutLogin getCustomerWithoutLogin(String customerId) {
		return customerWithoutLoginDao.getCustomerWithoutLogin(customerId);
	}

	public void saveCustomerWithoutLogin(CustomerWithoutLogin customerWithoutLogin) {
		customerWithoutLoginDao.saveCustomerWithoutLogin(customerWithoutLogin);
	}

	public double calculateGrandTotal(List<CartItemWithoutLogin> cartItemWithoutLogin) {
		double d=0;
		for(CartItemWithoutLogin item:cartItemWithoutLogin) {
			d=d+item.getPrice();
		}
		return d;
	}

}
