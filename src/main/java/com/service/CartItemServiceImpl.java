package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartItemDao;
import com.model.Cart;
import com.model.CartItem;
import com.model.CartItemWithoutLogin;
import com.model.CartWithoutLogin;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;

	public CartItemDao getCartItemDao() {
		return cartItemDao;
	}

	public void setCartItemDao(CartItemDao cartItemDao) {
		this.cartItemDao = cartItemDao;
	}

	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);

	}

	public void removeCartItem(int CartItemId) {
		cartItemDao.removeCartItem(CartItemId);
	}

	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
	}

	public void addCartItemWithoutLogin(CartItemWithoutLogin cartItem) {
		cartItemDao.addCartItemWithoutLogin(cartItem);
		
	}

	public void removeCartItemWithoutLogin(int CartItemId) {
		cartItemDao.removeCartItemWithoutLogin(CartItemId);		
	}

	public void removeAllCartItemsWithoutLogin(CartWithoutLogin cartWithoutLogin) {
		cartItemDao.removeAllCartItemWithoutLogin(cartWithoutLogin);	
		
	}

}
