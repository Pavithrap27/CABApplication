package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.entity.Customer;

@Service
<<<<<<< HEAD
public class ICustomerService {
	@Autowired
	ICustomerRepository customerrepo;
	
	public List<Customer> getCustomer() throws CustomerNotFoundException
	{
		List<Customer> customer = customerrepo.findAll();
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("No Customer found");
		} else {
			return customer;
		}
	}
=======
public interface ICustomerService {
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

<<<<<<< HEAD
	public Customer insertCustomer(Customer customer) throws CustomerNotFoundException
	{
		if (customer == null) {
			throw new CustomerNotFoundException("No Customer found");
		} else {
			customerrepo.save(customer);
			return customer;
		}
	}
=======
	public Customer insertCustomer(Customer customer);
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

<<<<<<< HEAD
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException
	{
		if(customer == null) {
			throw new CustomerNotFoundException("No Customer found");
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
=======
	public Customer updateCustomer(Customer customer);
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

<<<<<<< HEAD
	public String deleteCustomer(int customerId) throws CustomerNotFoundException
	{
		Customer customer = customerrepo.findById(customerId).orElseThrow();
		if(customer == null)
		{
			throw new CustomerNotFoundException("No Customer found");
=======
	public String deleteCustomer(int customerId);
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

	public List<Customer> viewCustomers();

<<<<<<< HEAD
	public List<Customer> viewCustomers() throws CustomerNotFoundException {
		List<Customer> customersList = customerrepo.findAll();
		if(customersList.isEmpty())
		{
			throw new CustomerNotFoundException("No Customer found");
		}
		return customersList;
	}
=======
	public Customer viewCustomer(int customerId);
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

<<<<<<< HEAD
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException 
	{
		Customer customer = customerrepo.findById(customerId).orElseThrow();
		if(customer == null)
		{
			throw new CustomerNotFoundException("No Customer found");
		}
		return customer;
	}

	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException
	{
		Customer customer = customerrepo.validateCustomer(username, password);
		if(customer == null)
		{
			throw new CustomerNotFoundException("No Customer found");
		}
		return customer;
	}
=======
	public Customer validateCustomer(String username, String password);
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git
}
