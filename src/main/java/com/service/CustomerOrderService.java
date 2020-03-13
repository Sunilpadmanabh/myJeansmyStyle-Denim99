package com.service;

import com.model.CustomerOrder;
import com.model.CustomerOrderWithoutLogin;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(int cartId);
	void addCustomerOrderWithoutLogin(CustomerOrderWithoutLogin customerOrder);
	double getCustomerOrderGrandTotalWithoutLogin(String cartId);
}
