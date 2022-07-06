package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.entity.Customer;

@Service
public interface ICustomerService {

	public Customer insertCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public String deleteCustomer(int customerId);

	public List<Customer> viewCustomers();

	public Customer viewCustomer(int customerId);

	public Customer validateCustomer(String username, String password);
}
