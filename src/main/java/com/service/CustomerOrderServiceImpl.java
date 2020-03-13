package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerOrderDao;
import com.model.Cart;
import com.model.CartItem;
import com.model.CartItemWithoutLogin;
import com.model.CartWithoutLogin;
import com.model.CustomerOrder;
import com.model.CustomerOrderWithoutLogin;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Autowired
	private CartService cartService;
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDao.addCustomerOrder(customerOrder);
	}

	public double getCustomerOrderGrandTotal(int cartId) {
		double grandTotal=0;
		Cart cart = cartService.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(CartItem item: cartItems){
			grandTotal += item.getPrice();
		}
		return grandTotal;
	}

	public void addCustomerOrderWithoutLogin(CustomerOrderWithoutLogin customerOrder) {
		customerOrderDao.addCustomerOrderWithoutLogin(customerOrder);
	}

	public double getCustomerOrderGrandTotalWithoutLogin(String cartId) {
		double grandTotal=0;
		CartWithoutLogin cart = cartService.getCartWithoutLoginByCartId(cartId);
		List<CartItemWithoutLogin> cartItems = cart.getCartItemWithoutLogin();
		
		for(CartItemWithoutLogin item: cartItems){
			grandTotal += item.getPrice();
		}
		return grandTotal;
	}

}
