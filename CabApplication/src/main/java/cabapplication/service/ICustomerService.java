package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Customer;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.repository.ICustomerRepository;


@Service
public class ICustomerService {
	@Autowired
	ICustomerRepository customerrepo;
	
	public List<Customer> getCustomer() throws CustomerNotFoundException
	{
		List<Customer> customer = customerrepo.findAll();
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			return customer;
		}
	}

	public Customer insertCustomer(Customer customer) throws CustomerNotFoundException
	{
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			customerrepo.save(customer);
			return customer;
		}
	}

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException
	{
		if(customer == null) {
			throw new CustomerNotFoundException("Customer not found");
		}
		else
		{
			int id = customer.getCustomerId();
			Customer c = customerrepo.findById(id).orElseThrow();
			c.setCustomerId(c.getCustomerId());
			c.setEmail(customer.getEmail());
			c.setAddress(customer.getAddress());
			c.setMobileNumber(customer.getMobileNumber());
			c.setPassword(customer.getPassword());
			c.setUsername(customer.getUsername());
			customerrepo.save(c);
			return c;
		}
	}

	public String deleteCustomer(int customerId) throws CustomerNotFoundException
	{
		Customer customer = customerrepo.findById(customerId).orElseThrow();
		if(customer == null)
		{
			throw new CustomerNotFoundException("Customer not found");

		}
		else {
		customerrepo.deleteById(customerId);
		return "Deleted";
		}
	}
	

	public List<Customer> viewCustomers() throws CustomerNotFoundException {
		List<Customer> customersList = customerrepo.findAll();
		if(customersList.isEmpty())
		{
			throw new CustomerNotFoundException("Customer not found");
		}
		return customersList;
	}

	public Customer viewCustomer(int customerId) throws CustomerNotFoundException 
	{
		Customer customer = customerrepo.findById(customerId).orElseThrow();
		if(customer == null)
		{
			throw new CustomerNotFoundException("Customer not found");
		}
		return customer;
	}

	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException
	{
		Customer customer = customerrepo.validateCustomer(username, password);
		if(customer == null)
		{
			throw new CustomerNotFoundException("Customer not found");
		}
		return customer;
	}
}
