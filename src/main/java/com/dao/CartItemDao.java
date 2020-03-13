package com.dao;

import com.model.Cart;
import com.model.CartItem;
import com.model.CartItemWithoutLogin;
import com.model.CartWithoutLogin;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);
	void removeCartItem(int CartItemId);
	void removeAllCartItems(Cart cart);
	void addCartItemWithoutLogin(CartItemWithoutLogin cartItem);
	void removeCartItemWithoutLogin(int cartItemId);
	void removeAllCartItemWithoutLogin(CartWithoutLogin cartWithoutLogin);

}
