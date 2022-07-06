package cabapplication.service;

import java.util.List;

import cabapplication.dto.CustomerDTO;
import cabapplication.entity.Customer;
import cabapplication.exception.CustomerNotFoundException;

public interface ICustomerService {

	public CustomerDTO save(Customer customer) throws CustomerNotFoundException;
		
	public CustomerDTO update(Customer customer) throws CustomerNotFoundException;

	public String delete(int customerId) throws CustomerNotFoundException;

	public List<CustomerDTO> getAll() throws CustomerNotFoundException;

	public CustomerDTO getById(int customerId)throws CustomerNotFoundException;

	public CustomerDTO validateCustomer(String username, String password)throws CustomerNotFoundException;
}