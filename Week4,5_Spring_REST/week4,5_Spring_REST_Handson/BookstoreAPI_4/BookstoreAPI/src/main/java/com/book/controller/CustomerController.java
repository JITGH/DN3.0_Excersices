package com.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.entity.Customer;
import com.book.services.CustomerService;


@Controller
@RequestMapping("/api/customers")
public class CustomerController {
	private CustomerService customerService;
	public CustomerController(CustomerService customerService) {
	    this.customerService = customerService;
	}
	
	@RequestMapping ("/test")
public String test()
{
		return "welcome";
}
	
@RequestMapping(value="register")
public String getRegister(Model model)
{
	model.addAttribute("customer", new Customer());
	return "registration";
}

@RequestMapping(value="save",method = RequestMethod.POST)
public String registerCustomer1(@ModelAttribute("customer") Customer customer) {

    //Customer customer = new Customer(0,name, email, password);
    Customer savedCustomer = customerService.addCustomer(customer);
    return "registration";
}

}
