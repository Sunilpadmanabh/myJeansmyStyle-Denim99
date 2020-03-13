package com.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.BillingAddress;
import com.model.Customer;
import com.model.ShippingAddress;
import com.model.User;
import com.service.CustomerService;
import com.util.HashCode;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;

	@Autowired
	HashCode hashCode;
	
	public HashCode getHashCode() {
		return hashCode;
	}

	public void setHashCode(HashCode hashCode) {
		this.hashCode = hashCode;
	}

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "**/registration", method = RequestMethod.GET)
	public String getRegistrationForm(Map<String, Object> model) {
		Customer customer = new Customer();
		User user = new User();
		BillingAddress ba = new BillingAddress();
		ShippingAddress sa = new ShippingAddress();
		customer.setShippingAddress(sa);
		customer.setBillingAddress(ba);
		customer.setUsers(user);
		model.put("customer", customer);
		return "register1";
	}

	// to insert the data
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, Model model) {
		if (result.hasErrors())
			return "register";
		String hashPassword = hashCode.getHashPassword(customer.getUsers().getPassword());
		customer.getUsers().setPassword(hashPassword);
		customerService.addCustomer(customer);
		model.addAttribute("email", customer.getUsers().getEmailId());
		return "redirect:/verifyemail";
	}

}
