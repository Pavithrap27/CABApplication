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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.dto.CustomerDTO;
import cabapplication.entity.Customer;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.repository.ICustomerRepository;
import cabapplication.utils.Converter;

@SpringBootTest
class CustomerServiceImplTest {
	
	@Autowired
	CustomerServiceImpl customerService;
	@Autowired
	static Converter converter;
	
	@MockBean
	ICustomerRepository customerrepo;

	CustomerDTO customerDto1 = null;
	CustomerDTO customerDto2 = null;
	
	@BeforeEach
	public void testBeforeEach() {
		
		customerDto1 = new CustomerDTO();
		customerDto1.setUsername("Siri");
		customerDto1.setPassword("siri123");
		customerDto1.setMobileNumber("9901296413");
		customerDto1.setAddress("Bangalore");
		customerDto1.setCustomerId(1);
		customerDto1.setEmail("siri666@gmail.com");
		
		customerDto2 = new CustomerDTO();
		customerDto2.setUsername("Deeksha");
		customerDto2.setPassword("dee123");
		customerDto2.setMobileNumber("9876544322");
		customerDto2.setAddress("Chennai");
		customerDto2.setCustomerId(2);
		customerDto2.setEmail("dee123@gmail.com");
	}
	
	@Test
	void testGetAll() throws CustomerNotFoundException
	{
		List<CustomerDTO> customer = new ArrayList<>();
		customer.add(customerDto1);
		customer.add(customerDto2);
		List<Customer> list = Converter.convertCustomerDtoToEntity(customer);
		Mockito.when(customerrepo.findAll()).thenReturn(list);
		assertNotNull(customerService.getAll());
	}
	@Test
	void testSave() throws Throwable
	{
		Customer customer = Converter.convertCustomerDtoToEntity(customerDto1);
	        Mockito.when(customerrepo.save(customer)).thenReturn(customer);
	        assertThat(customerService.save(customerDto1)).isEqualTo(customerDto1);
	 
	}

	@Test
	void testUpdate() throws Throwable
	{
		Customer customer = Converter.convertCustomerDtoToEntity(customerDto1);
        Optional<Customer> optional = Optional.of(customer);
        Mockito.when(customerrepo.findById(1)).thenReturn(optional);
        Mockito.when(customerrepo.save(customer)).thenReturn(customer);
        assertNotNull(customerService.update(customerDto1));	
	}

	@Test
	void testDelete() {
		Customer customer = Converter.convertCustomerDtoToEntity(customerDto1);
        Optional<Customer> optional = Optional.of(customer);
 
        Mockito.when(customerrepo.findById(1)).thenReturn(optional);
        Mockito.when(customerrepo.existsById(customer.getCustomerId())).thenReturn(false);
        assertFalse(customerrepo.existsById(customer.getCustomerId()));
	}

	@Test
	void testGetById() throws CustomerNotFoundException {
		Customer customer = Converter.convertCustomerDtoToEntity(customerDto1);
	        Optional<Customer> optional = Optional.of(customer);
	        Mockito.when(customerrepo.findById(1)).thenReturn(optional);
	        assertThat(customerrepo.existsById(customer.getCustomerId()));
	}

	@Test
	void testValidate()throws Throwable {
		Customer customer = Converter.convertCustomerDtoToEntity(customerDto1);

		 Mockito.when(customerrepo.getByUsernameAndPassword("Siri","siri123")).thenReturn(customer);
	        assertThat(customerService.validate("Siri","siri123").equals(customerDto1));
	}
}
