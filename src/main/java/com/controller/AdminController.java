package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.CustomerDao;


@Controller
public class AdminController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping(value = "**/admin/deleteUser", method = RequestMethod.GET)
	public String deleteCustomer(Model model){
		model.addAttribute("email", "");
		return "deleteuser";
	}
	
	@RequestMapping(value = "**/admin/deleteUser", method = RequestMethod.POST)
	public String deleteCustomerUsingEmail(@ModelAttribute("email") String email){
		customerDao.deleteCustomer(email);
		return "redirect:/index1";
	}
	
}
