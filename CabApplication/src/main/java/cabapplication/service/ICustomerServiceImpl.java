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
	
	@Override
	public List<CustomerDTO> getAll() throws CustomerNotFoundException {
		List<CustomerDTO> customerDto = Converter.convertCustomersToDTO(customerrepo.findAll());
		if (customerDto.isEmpty()) {
			throw new CustomerNotFoundException("No Customer available");
		} else {
			return customerDto;
		}
	}
	
	@Override
	public CustomerDTO save(CustomerDTO customerDto) throws CustomerNotFoundException {
		if (customerDto == null) {
			throw new CustomerNotFoundException("Customer Does not exist");
		} else {
			customerrepo.save(Converter.convertCustomerToEntity(customerDto));
			return customerDto;
		}

	}
	
	@Override
	public CustomerDTO update(CustomerDTO customerDto)throws CustomerNotFoundException {
		if (customerDto == null) {
			throw new CustomerNotFoundException("No Customer found");
		} else {
			Customer customer = Converter.convertCustomerToEntity(customerDto);
		int id = customer.getCustomerId();
		Customer customerUpdated = customerrepo.findById(id).orElseThrow();
		customerUpdated.setCustomerId(customerUpdated.getCustomerId());
		customerUpdated.setEmail(customer.getEmail());
		customerUpdated.setAddress(customer.getAddress());
		customerUpdated.setMobileNumber(customer.getMobileNumber());
		customerUpdated.setPassword(customer.getPassword());
		customerUpdated.setUsername(customer.getUsername());
		customerrepo.save(customerUpdated);
		return Converter.convertCustomerToDto(customerUpdated);
		}
	}

	@Override
	public String delete(int customerId)throws CustomerNotFoundException{
		CustomerDTO customerDto = Converter.convertCustomerToDto(customerrepo.findById(customerId).orElseThrow());
		if (customerDto == null) {
			throw new CustomerNotFoundException("No Customer found");
		} else {
			customerrepo.delete(Converter.convertCustomerToEntity(customerDto));
			return "Deleted";
		}
	}
	
	@Override
	public CustomerDTO  getById(int customerId)throws CustomerNotFoundException 
	{
		if((customerrepo.findById(customerId).orElseThrow())!=null)
		{
			return Converter.convertCustomerToDto(customerrepo.findById(customerId).orElseThrow());
		}
		
		throw new CustomerNotFoundException("Customer not found");
		
	}
	
	@Override
	public CustomerDTO validate(String username, String password)throws CustomerNotFoundException 
	{
		if(customerrepo.getByUsernameAndPassword(username, password)!=null) {
			
			 return Converter.convertCustomerToDto(customerrepo.getByUsernameAndPassword(username, password));
		}
		
		throw new CustomerNotFoundException("Customer not found");
	}
}
