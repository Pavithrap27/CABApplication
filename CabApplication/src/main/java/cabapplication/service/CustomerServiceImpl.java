package cabapplication.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cabapplication.dto.CustomerDTO;
import cabapplication.entity.Customer;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.repository.ICustomerRepository;
import cabapplication.utils.Converter;


@Service
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	ICustomerRepository customerrepo;
	
	@Override
	public List<CustomerDTO> getAll() throws CustomerNotFoundException {
		List<Customer> customer = customerrepo.findAll();
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("No Customer available");
		} else {
			return Converter.convertCustomersToDto(customer);
		}
	}
		
	@Override
	public CustomerDTO save(CustomerDTO customerDto) throws Throwable 
	{
		if(customerDto.getUsername()!=null)
		{
			customerrepo.save(Converter.convertCustomerDtoToEntity(customerDto));
			return customerDto;
		}
		throw new CustomerNotFoundException("Customer not available");
	}
	
	@Override
	public CustomerDTO update(CustomerDTO customerDto)throws CustomerNotFoundException 
	{
		if(customerDto == null) {
			throw new CustomerNotFoundException("Customer not found");
		}else {
		Customer customer = Converter.convertCustomerDtoToEntity(customerDto);
		int id = customer.getCustomerId();
		Customer customerUpdated = customerrepo.findById(id).orElseThrow();
		customerUpdated.setCustomerId(customerUpdated.getCustomerId());
		customerUpdated.setEmail(customer.getEmail());
		customerUpdated.setAddress(customer.getAddress());
		customerUpdated.setMobileNumber(customer.getMobileNumber());
		customerUpdated.setPassword(customer.getPassword());
		customerUpdated.setUsername(customer.getUsername());
		customerrepo.save(customerUpdated);
		return customerDto;
		}
	}

	@Override
	public String delete(int customerId)throws Throwable
	{
		Supplier<CustomerNotFoundException> s1=()->new CustomerNotFoundException("Customer not found");
		Converter.convertCustomerToDto(customerrepo.findById(customerId).orElseThrow(s1));
			customerrepo.deleteById(customerId);
			return "Deleted";
	}
	
	@Override
	public CustomerDTO  getById(int customerId)throws Throwable 
	{
		Supplier<CustomerNotFoundException> s1=()->new CustomerNotFoundException("Customer not found");
		return Converter.convertCustomerToDto(customerrepo.findById(customerId).orElseThrow(s1));
		
	}
	
	@Override
	public CustomerDTO validate(String username, String password)throws Throwable {
	if(customerrepo.getByUsernameAndPassword(username, password)!=null) {

        return Converter.convertCustomerToDto(customerrepo.getByUsernameAndPassword(username, password));
   }

   throw new CustomerNotFoundException("Customer not found");
	}
}
