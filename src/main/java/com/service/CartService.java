package com.service;

import com.model.Cart;
import com.model.CartWithoutLogin;

public interface CartService {

	Cart getCartByCartId(int CartId);

	CartWithoutLogin getCartWithoutLoginByCartId(String cartId);
}
