package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UrlPathHelper;

import com.model.Cart;
import com.model.CartItem;
import com.model.CartItemWithoutLogin;
import com.model.CartWithoutLogin;
import com.model.Customer;
import com.model.CustomerWithoutLogin;
import com.model.Product;
import com.service.CartItemService;
import com.service.CartService;
import com.service.CustomerService;
import com.service.CustomerWithoutLoginService;
import com.service.ProductService;

@Controller
public class CartItemController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerWithoutLoginService customerServiceWithoutLogin;

	@Autowired
	private ProductService productService;

	public CustomerWithoutLoginService getCustomerServiceWithoutLogin() {
		return customerServiceWithoutLogin;
	}

	public void setCustomerServiceWithoutLogin(CustomerWithoutLoginService customerServiceWithoutLogin) {
		this.customerServiceWithoutLogin = customerServiceWithoutLogin;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public CartItemService getCartItemService() {
		return cartItemService;
	}

	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	@RequestMapping("**/cart/add/{productId}")
	public String addCartItem(@PathVariable(value = "productId") int productId, HttpServletRequest request,
			HttpServletResponse response) {
		CartWithoutLogin cartWithoutLogin;
		String referer = request.getHeader("Referer");
	   
		if (request.getUserPrincipal() == null) {

			String id = request.getSession().getId();
			CustomerWithoutLogin cust = customerServiceWithoutLogin.getCustomerWithoutLogin(id);
			if (cust == null) {
				cust = new CustomerWithoutLogin();
				cust.setCustomerId(id);
				customerServiceWithoutLogin.saveCustomerWithoutLogin(cust);
			}
			cartWithoutLogin = cust.getCartWithoutLogin();
			List<CartItemWithoutLogin> cartItemsWithoutLogin = cartWithoutLogin.getCartItemWithoutLogin();
			if (cartItemsWithoutLogin == null) {
				cartItemsWithoutLogin = new ArrayList<CartItemWithoutLogin>();
				cartWithoutLogin.setCartItemWithoutLogin(cartItemsWithoutLogin);
			}
			Product product = productService.getProductById(productId);
			for (int i = 0; i < cartItemsWithoutLogin.size(); i++) {
				CartItemWithoutLogin cartItem = cartItemsWithoutLogin.get(i);
				if (product.getProductId() == cartItem.getProduct().getProductId()) {
					cartItem.setQuality(cartItem.getQuality() + 1);
					cartItem.setPrice(cartItem.getQuality() * cartItem.getProduct().getProductPrice());
					cartItemService.addCartItemWithoutLogin(cartItem);
					return "redirect:"+ referer;
				}
			}
			CartItemWithoutLogin cartItem = new CartItemWithoutLogin();
			cartItem.setQuality(1);
			cartItem.setProduct(product);
			cartItem.setPrice(product.getProductPrice() * 1);
			cartItem.setCartWithoutLogin(cartWithoutLogin);
			cartItemService.addCartItemWithoutLogin(cartItem);
		} else {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String emailId = user.getUsername();
			Customer customer = customerService.getCustomerByemailId(emailId);
			System.out.println("Customer : " + customer.getUsers().getEmailId());
			Cart cart = customer.getCart();
			System.out.println(cart);
			List<CartItem> cartItems = cart.getCartItem();
			Product product = productService.getProductById(productId);
			for (int i = 0; i < cartItems.size(); i++) {
				CartItem cartItem = cartItems.get(i);
				if (product.getProductId() == cartItem.getProduct().getProductId()) {
					cartItem.setQuality(cartItem.getQuality() + 1);
					cartItem.setPrice(cartItem.getQuality() * cartItem.getProduct().getProductPrice());
					cartItemService.addCartItem(cartItem);
					return "redirect:"+ referer;
				}
			}
			CartItem cartItem = new CartItem();
			cartItem.setQuality(1);
			cartItem.setProduct(product);
			cartItem.setPrice(product.getProductPrice() * 1);
			cartItem.setCart(cart);
			cartItemService.addCartItem(cartItem);
		}
		 return "redirect:"+ referer;
	}

	@RequestMapping("**/cart/removeCartItem/{cartItemId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable(value = "cartItemId") int cartItemId) {
		cartItemService.removeCartItem(cartItemId);
	}
	
	@RequestMapping("**/cart/removeCartItemWithoutLogin/{cartItemId}")
	public String removeCartItemWithoutLogin(@PathVariable(value = "cartItemId") int cartItemId) {
		cartItemService.removeCartItemWithoutLogin(cartItemId);
		return "redirect:/cart/getCartById";
	}

	@RequestMapping("**/cart/removeAllItems/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeAllCartItems(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartByCartId(cartId);
		cartItemService.removeAllCartItems(cart);
	}

	@RequestMapping("**/cart/removeAllItemsWithoutLogin/{cartId}")
	public String removeAllCartItemsWithoutLogin(@PathVariable(value = "cartId") String cartId) {
		CartWithoutLogin cartWithoutLogin=cartService.getCartWithoutLoginByCartId(cartId);
		cartItemService.removeAllCartItemsWithoutLogin(cartWithoutLogin);
		return "redirect:/cart/getCartById";
	}
}
