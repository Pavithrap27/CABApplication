package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.dto.CustomerDTO;
import cabapplication.dto.DriverDTO;
import cabapplication.entity.Customer;
import cabapplication.repository.ICustomerRepository;
import cabapplication.utils.Converter;

class CustomerServiceImplTest {
	
	@Autowired
	CustomerServiceImpl customerservice;
	
	@Autowired
	static Converter converter;
	
	@MockBean
	ICustomerRepository customerrepo;

	CustomerDTO customer=null;
	
	@BeforeEach
	public void testBeforeEach() {
		
		customer=new CustomerDTO();
		
		
		customer.setUsername("Siri");
		customer.setPassword("siri123");
		customer.setMobileNumber("9901296413");
		customer.setAddress("Bangalore");
		customer.setCustomerId(25);
		customer.setEmail("siri666@gmail.com");
		
		customer.setUsername("Deeksha");
		customer.setPassword("dee123");
		customer.setMobileNumber("9876544322");
		customer.setAddress("Chennai");
		customer.setCustomerId(26);
		customer.setEmail("dee123@gmail.com");
		
	}
	@Test
	void testGetAll() throws Throwable {
		
		List<Customer> customerList=new ArrayList<>();
		customerList.add(Converter.convertCustomerDtoToEntity(customer));
		
		
		Mockito.when(customerrepo.findAll()).thenReturn(customerList);
		assertThat(customerservice.getAll());
		
	}

	@Test
	void testSave() throws Throwable
	{
		Customer customerc=Converter.convertCustomerDtoToEntity(customer);
		Mockito.when(customerrepo.save(customerc)).thenReturn(customerc);
		assertThat(customerservice.save(customer)).isEqualTo(customer);
	}

	@Test
	void testUpdate() throws Throwable
	{
		Customer customer=Converter.convertCustomerDtoToEntity(customer);
		Optional<Customer> customer=Optional.of(customer);
		Customer customer1=Converter.convertCustomerDtoToEntity(customerc);
		Mockito.when(customerrepo.findById(25)).thenReturn(customer);
		
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testValidate() {
		fail("Not yet implemented");
	}

}
