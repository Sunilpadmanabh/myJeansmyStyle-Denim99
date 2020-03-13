package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.CartItem;
import com.model.CartItemWithoutLogin;
import com.model.CustomerWithoutLogin;
import com.model.Product;
import com.model.Queries;
import com.service.CustomerService;
import com.service.CustomerWithoutLoginService;
import com.service.ProductService;
import com.service.QueriesService;
import com.util.HashCode;
//this is the controller were it's first preffered
@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerWithoutLoginService customerServiceWithoutLogin;

	// Getters and Setters

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	private CustomerService customerService;

	// Getters and Setters

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping({ "**/index1", "/" })
	public String sayIndex(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setDateHeader("Expires", 0);
		List<Product> products = productService.getAllProducts();
		model.put("products", products);
		int itemcount = 0;
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
			List<CartItem> cartitems = customerService.getCustomerByemailId(request.getUserPrincipal().getName())
					.getCart().getCartItem();
			if (cartitems != null)
				itemcount = cartitems.size();
		} else {
			String id = request.getSession().getId();
			CustomerWithoutLogin cust = customerServiceWithoutLogin.getCustomerWithoutLogin(id);
			if (cust != null) {
				if (cust.getCartWithoutLogin() != null) {
					List<CartItemWithoutLogin> cartitemswithoutlogin = cust.getCartWithoutLogin()
							.getCartItemWithoutLogin();
					if (cartitemswithoutlogin != null) {
						itemcount = cartitemswithoutlogin.size();
					}
				}
			}
		}
		model.put("itemcount", itemcount);
		return "index1";
	}

	@RequestMapping("/prodi")
	public String sayInd(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		List<Product> products = productService.getAllProducts();
		model.put("products", products);
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		return "productGrid";
	}

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		return new ModelAndView("hello", "hello", "Hello ");
	}

	@RequestMapping("**/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request, HttpServletResponse response, Model model) {
		if (error != null)
			model.addAttribute("error", "Invalid username and Password");
		if (logout != null) {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setDateHeader("Expires", 0);
			model.addAttribute("logout", "You have logged out successfully");
		}
			return "login";
	}

	@RequestMapping("/aboutus")
	public String sayAbout(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		if (request.getUserPrincipal() != null) {
			model.put("currentUser", customerService.getCurrentUser());
		}
		return "aboutUs";
	}

	@Autowired
	private QueriesService queryService;

	@RequestMapping(value = "/contactus")
	public ModelAndView getQuery() {
		Queries query = new Queries();
		return new ModelAndView("contactUs", "contact", query);
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public String addQuery(@Valid @ModelAttribute(value = "contact") Queries query, Model model, BindingResult result) {

		if (result.hasErrors())
			return "contactUs";

		queryService.addQuery(query);
		model.addAttribute("error",
				"Thank you, Your Message stored in our Server we will contact through corresponding Mail");
		return "login";

	}
	
	@RequestMapping("/userdetails")
	public String userdetail(HttpServletRequest request, HttpServletResponse response,Map<String, Object> model) {
		if(request.getUserPrincipal()!=null) {
		model.put("customer", customerService.getCustomerByemailId(request.getUserPrincipal().getName()));
		}
		return "userDetails";
	}
}
