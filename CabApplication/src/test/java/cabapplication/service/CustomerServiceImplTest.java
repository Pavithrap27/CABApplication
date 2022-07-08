package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.dto.CustomerDTO;
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

	@Test
	void testGetAll() throws Throwable {
		
		CustomerDTO customer=new CustomerDTO(); 
		customer.setUsername("Siri");
		customer.setPassword("siri123");
		customer.setMobileNumber("9901296413");
		customer.setAddress("Bangalore");
		customer.setCustomerId(25);
		customer.setEmail("siri666@gmail.com");
		
		CustomerDTO customer1=new CustomerDTO(); 
		customer1.setUsername("Deeksha");
		customer1.setPassword("dee123");
		customer1.setMobileNumber("9876544322");
		customer1.setAddress("Chennai");
		customer1.setCustomerId(26);
		customer1.setEmail("dee123@gmail.com");

		List<Customer> customerList=new ArrayList<>();
		customerList.add(Converter.convertCustomerDtoToEntity(customer));
		customerList.add(Converter.convertCustomerDtoToEntity(customer1));
		
		Mockito.when(customerrepo.findAll()).thenReturn(customerList);
		assertThat(customerservice.save(customer1)).isEqualTo(customerList);
		
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
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
