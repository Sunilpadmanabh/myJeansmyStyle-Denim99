package com.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;
import com.model.CartWithoutLogin;
import com.service.CustomerOrderService;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerOrderService customerOrderService;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Cart getCartByCartId(int CartId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, CartId);
		// System.out.println(cart.getCartId() + " " + cart.getCartItem());
		System.out.println(cart);
		session.close();
		return cart;

	}

	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartByCartId(cartId);
		if (cart == null || cart.getCartItem().size() == 0) {
			throw new IOException(cartId + "");
		}
		update(cart);
		return cart;
	}

	public CartWithoutLogin validateWithoutLogin(String cartId) throws IOException {
		CartWithoutLogin cart = getCartWithoutLoginByCartId(cartId);
		if (cart == null || cart.getCartItemWithoutLogin().size() == 0) {
			throw new IOException(cartId + "");
		}
		updateWithoutLogin(cart);
		return cart;
	}
	
	public void updateWithoutLogin(CartWithoutLogin cart) {

		String cartId = cart.getCartId();
		double grandTotal = customerOrderService.getCustomerOrderGrandTotalWithoutLogin(cartId);
		cart.setTotalPrice(grandTotal);

		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cart);
		session.flush();
		session.close();
	}
	
	public void update(Cart cart) {

		int cartId = cart.getCartId();
		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
		cart.setTotalPrice(grandTotal);

		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cart);
		session.flush();
		session.close();
	}

	public CartWithoutLogin getCartWithoutLoginByCartId(String CartId) {
		Session session = sessionFactory.openSession();
		CartWithoutLogin cart = (CartWithoutLogin) session.get(CartWithoutLogin.class, CartId);
		// System.out.println(cart.getCartId() + " " + cart.getCartItem());
		System.out.println(cart);
		session.close();
		return cart;
	}

}
