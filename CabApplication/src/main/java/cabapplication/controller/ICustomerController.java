package cabapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.Customer;
import cabapplication.service.ICustomerService;

@RestController
public class ICustomerController {

	@Autowired
	ICustomerService customerservice;
	
	@PostMapping(path="/insertcustomer")
	public Customer insertCustomer(Customer customer)
	{
		return customerservice.insertCustomer(customer);
	}
	@PutMapping(path="/updatecustomer")
	public Customer updateCustomer(Customer customer)
	{
		return customerservice.updateCustomer(customer);
	}
	
}
