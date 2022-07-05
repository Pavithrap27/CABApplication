package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Customer;
import cabapplication.entity.Driver;
import cabapplication.repository.ICustomerRepository;


@Service
public class ICustomerService {
	
	@Autowired
	ICustomerRepository customerrepo;

	public Customer insertCustomer(Customer customer)
	{
		return customerrepo.save(customer);
	}
	public Customer updateCustomer(Customer customer)
	{
		int id=customer.getCustomerId();
		Customer c=customerrepo.findById(id).orElseThrow();
		c.setCustomerId(c.getCustomerId());
		customerrepo.save(c);
		return c;
	}
	public String deleteCustomer(int customerId)
	{
		Customer c=customerrepo.findById(customerId).orElseThrow();
		customerrepo.deleteById(customerId);
		return "Deleted";
	}
	public List<Customer> viewCustomers()
	{
		List<Customer> lc=customerrepo.findAll();
		return lc;
	}
	public Customer viewCustomer(int customerId)
	{
		return customerrepo.findById(customerId).orElseThrow();
	}
	public Customer validateCustomer(String username, String password)
	{
		return null;
		
	}
	
	
	
}
