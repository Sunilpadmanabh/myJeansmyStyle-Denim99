package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Cart;
import com.model.CartItem;
import com.model.CartItemWithoutLogin;
import com.model.CartWithoutLogin;
import com.model.Customer;
import com.model.CustomerWithoutLogin;
import com.service.CartService;
import com.service.CustomerService;
import com.service.CustomerWithoutLoginService;

@Controller
public class CartController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerWithoutLoginService customerServiceWithoutLogin;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CustomerWithoutLoginService getCustomerServiceWithoutLogin() {
		return customerServiceWithoutLogin;
	}

	public void setCustomerServiceWithoutLogin(CustomerWithoutLoginService customerServiceWithoutLogin) {
		this.customerServiceWithoutLogin = customerServiceWithoutLogin;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	@RequestMapping("**/getCartById")
	public String getCartId(HttpServletRequest request, HttpServletResponse response, Model model) {
		if (request.getUserPrincipal() != null) {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String emailId = user.getUsername();
			Customer customer = customerService.getCustomerByemailId(emailId);
			model.addAttribute("cartId", customer.getCart().getCartId());

			model.addAttribute("currentUser", customerService.getCurrentUser());

			List<CartItem> cartitems = customerService.getCustomerByemailId(request.getUserPrincipal().getName())
					.getCart().getCartItem();
			if (cartitems != null) {
				int itemcount = cartitems.size();
				model.addAttribute("itemcount", itemcount);
			}
		} else {
			try {
				String id = request.getSession().getId();
				CustomerWithoutLogin cust = customerServiceWithoutLogin.getCustomerWithoutLogin(id);
				Double d = customerServiceWithoutLogin
						.calculateGrandTotal(cust.getCartWithoutLogin().getCartItemWithoutLogin());
				model.addAttribute("cartId", cust.getCartWithoutLogin().getCartId());
				model.addAttribute("carts", cust.getCartWithoutLogin().getCartItemWithoutLogin());
				if (cust.getCartWithoutLogin() != null) {
					List<CartItemWithoutLogin> cartitemswithoutlogin = cust.getCartWithoutLogin()
							.getCartItemWithoutLogin();
					if (cartitemswithoutlogin != null) {
						int itemcount = cartitemswithoutlogin.size();
						model.addAttribute("itemcount", itemcount);
					}
				}
				// calculating total price
				model.addAttribute("calculateGrandTotal", d);
			} catch (Exception e) {
				return "cartWithoutLogin";
			}
			return "cartWithoutLogin";
		}
		return "cart";
	}

	@RequestMapping("**/cart/getCart/{cartId}")
	public @ResponseBody Cart getCartItems(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartByCartId(cartId);
	}

	@RequestMapping("**/cart/getCartWithoutLogin/{cartId}")
	public @ResponseBody CartWithoutLogin getCartItemsWithoutLogin(@PathVariable(value = "cartId") String cartId) {
		return cartService.getCartWithoutLoginByCartId(cartId);
	}

}
