package com.dao;

import java.io.IOException;

import com.model.Cart;
import com.model.CartWithoutLogin;

public interface CartDao {

	Cart getCartByCartId(int CartId);
	
	Cart validate(int cartId) throws IOException;
	
	void update(Cart cart);
	
	CartWithoutLogin getCartWithoutLoginByCartId(String CartId);

}
