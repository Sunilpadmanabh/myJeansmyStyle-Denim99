package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.CartWithoutLogin;
import com.model.CustomerWithoutLogin;

@Repository
public class CustomerWithoutLoginDaoImpl implements CustomerWithoutLoginDao{

	@Autowired
	private SessionFactory sessionFactory;

	// this will create one sessionFactory for this class
	// there is only one sessionFactory should be created for the applications
	// we can create multiple sessions for a sessionFactory
	// each session can do some functions

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public CustomerWithoutLogin getCustomerWithoutLogin(String customerId) {
		Session session = sessionFactory.openSession();
		// select * from Product where isbn=i
		CustomerWithoutLogin customerWithoutLogin = (CustomerWithoutLogin) session.get(CustomerWithoutLogin.class, customerId);
		session.close();
		return customerWithoutLogin;
	}

	public void saveCustomerWithoutLogin(CustomerWithoutLogin customerWithoutLogin) {
		
		
		System.out.println("Adding customer in dao");
		Session session = sessionFactory.openSession();
		//customer - has users,shippingaddress
		//insert the users,billingaddress
//		customerWithoutLogin.getUsers().setEnabled(true);
		
		
		
		CartWithoutLogin cartWithoutLogin = new CartWithoutLogin();
		cartWithoutLogin.setCartId(customerWithoutLogin.getCustomerId());
		//it is to set CartId for customer table
		customerWithoutLogin.setCartWithoutLogin(cartWithoutLogin);//set the cart to the customer
		//if we omit this statement, hen it will insert null for customerid in cart
		//to set the customerid in cart table
		cartWithoutLogin.setCustomerWithoutLogin(customerWithoutLogin);
		session.save(customerWithoutLogin);
		session.flush();
		session.close();
	}

}
