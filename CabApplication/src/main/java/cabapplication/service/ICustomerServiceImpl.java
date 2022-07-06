package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.dto.CustomerDTO;
import cabapplication.entity.Customer;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.repository.ICustomerRepository;
import cabapplication.utils.Converter;


@Service
public class ICustomerServiceImpl implements ICustomerService
{
	@Autowired
	ICustomerRepository customerrepo;
	@Autowired
	Converter converter;
	
	@Override
	public List<CustomerDTO> getAll() throws CustomerNotFoundException {
		List<CustomerDTO> customerDto = converter.convertCustomersToDTO(customerrepo.findAll());
		if (customerDto.isEmpty()) {
			throw new CustomerNotFoundException("No Customer available");
		} else {
			return customerDto;
		}
	}
	public CustomerDTO save(CustomerDTO customerDto) throws CustomerNotFoundException {
		if (customerDto == null) {
			throw new CustomerNotFoundException("Customer Does not exist");
		} else {
			customerrepo.save(converter.convertCustomerToEntity(customerDto));
			return customerDto;
		}

	}
	
	public CustomerDTO updateCustomer(CustomerDTO customerDto)throws CustomerNotFoundException {
		if (customerDto == null) {
			throw new CustomerNotFoundException("No Customer found");
		} else {
			Customer customer = converter.convertCustomerToEntity(customerDto);
		int id = customer.getCustomerId();
		Customer customerUpdated = customerrepo.findById(id).orElseThrow();
		customerUpdated.setCustomerId(customerUpdated.getCustomerId());
		customerUpdated.setEmail(customer.getEmail());
		customerUpdated.setAddress(customer.getAddress());
		customerUpdated.setMobileNumber(customer.getMobileNumber());
		customerUpdated.setPassword(customer.getPassword());
		customerUpdated.setUsername(customer.getUsername());
		customerrepo.save(customerUpdated);
		return converter.convertCustomerToDto(customerUpdated);
		}
	}

	public String delete(CustomerDTO customerDto)throws CustomerNotFoundException{
		if (customerDto == null) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			customerrepo.delete(converter.convertCustomerToEntity(customerDto));
			return "Deleted";
		}
	}
	public CustomerDTO viewCustomer(CustomerDTO customerDto)throws CustomerNotFoundException {
		if (customerDto == null) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
		return customerrepo.findById(customerId).orElseThrow();
	}
	}
	public CustomerDTO validate(String username, String password) {
		CustomerDTO customer = customerrepo.validate(username, password);

		return customer;
	}
	
}
