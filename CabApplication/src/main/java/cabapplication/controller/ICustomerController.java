package cabapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.Customer;
import cabapplication.service.ICustomerService;

@RestController
@RequestMapping("customer")
public class ICustomerController {

	@Autowired
	ICustomerService customerservice;
	
	@PostMapping(path="/insertcustomer")
	public Customer insertCustomer(@RequestBody Customer customer)
	{
		return customerservice.insertCustomer(customer);
	}
	@PutMapping(path="/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return customerservice.updateCustomer(customer);
	}
	@DeleteMapping(path="/customerid")
	public String deleteCustomer(@PathVariable int customerId)
	{
		return customerservice.deleteCustomer(customerId);
	}
	@GetMapping(path="/viewcustomers")
	public List<Customer> viewCustomers()
	{
		return customerservice.viewCustomers();
	}
	@GetMapping(path="/viewcustomer{customerid}")
	public Customer viewCustomer(@PathVariable int customerId)
	{
		return customerservice.viewCustomer(customerId);
	}
	@GetMapping(path="/validatecustomer")
	public Customer validateCustomer(@PathVariable String username,@PathVariable String password)
	{
		return customerservice.validateCustomer(username, password);
	}
	
}
