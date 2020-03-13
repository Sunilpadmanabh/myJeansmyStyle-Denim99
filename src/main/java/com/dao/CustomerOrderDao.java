package com.dao;

import com.model.CustomerOrder;
import com.model.CustomerOrderWithoutLogin;

public interface CustomerOrderDao {

	void addCustomerOrder(CustomerOrder customerOrder);

	void addCustomerOrderWithoutLogin(CustomerOrderWithoutLogin customerOrder);
}
