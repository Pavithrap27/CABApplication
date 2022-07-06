package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Customer;
import cabapplication.repository.ICustomerRepository;


@Service
public class ICustomerServiceImpl implements ICustomerService
{
	@Autowired
	ICustomerRepository customerrepo;

	public Customer insertCustomer(Customer customer) {
		return customerrepo.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
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

	public String deleteCustomer(int customerId) {
		Customer c = customerrepo.findById(customerId).orElseThrow();
		customerrepo.deleteById(customerId);
		return "Deleted";
	}

	public List<Customer> viewCustomers() {
		return customerrepo.findAll();
	}

	public Customer viewCustomer(int customerId) {
		return customerrepo.findById(customerId).orElseThrow();
	}

	public Customer validateCustomer(String username, String password) {
		Customer customer = customerrepo.validateCustomer(username, password);

		return customer;
	}
}
