package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;
import com.model.CartItem;
import com.model.CartItemWithoutLogin;
import com.model.CartWithoutLogin;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();
	}

	public void removeCartItem(int CartItemId) {
		Session session = sessionFactory.openSession();
		CartItem cartItem = (CartItem) session.get(CartItem.class, CartItemId);
		session.delete(cartItem);
		Cart cart = cartItem.getCart();
		List<CartItem> cartItems = cart.getCartItem();
		cartItems.remove(cartItem);
		session.flush();
		session.close();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItem();
		for (CartItem cartItem : cartItems) {
			removeCartItem(cartItem.getCartItemId());
		}
	}

	public void addCartItemWithoutLogin(CartItemWithoutLogin cartItem) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();
		
	}

	public void removeCartItemWithoutLogin(int i) {
		Session session = sessionFactory.openSession();
		CartItemWithoutLogin cartItem = (CartItemWithoutLogin) session.get(CartItemWithoutLogin.class, i);
		session.delete(cartItem);
		CartWithoutLogin cart = cartItem.getCartWithoutLogin();
		List<CartItemWithoutLogin> cartItems = cart.getCartItemWithoutLogin();
		cartItems.remove(cartItem);
		session.flush();
		session.close();		
	}

	public void removeAllCartItemWithoutLogin(CartWithoutLogin cartWithoutLogin) {
		List<CartItemWithoutLogin> cartItems = cartWithoutLogin.getCartItemWithoutLogin();
		for (CartItemWithoutLogin cartItem : cartItems) {
			removeCartItemWithoutLogin(cartItem.getCartItemId());
		}		
	}

}
