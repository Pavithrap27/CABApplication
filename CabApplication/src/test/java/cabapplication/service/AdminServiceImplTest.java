package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.dto.AdminDTO;
import cabapplication.dto.CabDTO;
import cabapplication.dto.DriverDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
import cabapplication.entity.Cab;
import cabapplication.entity.Customer;
import cabapplication.entity.Driver;
import cabapplication.entity.TripBooking;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.repository.IAdminRepository;
import cabapplication.utils.Converter;

@SpringBootTest
class AdminServiceImplTest {

	
	@Autowired
	AdminServiceImpl adminservice;
	
	@Autowired
	TripServiceImpl tripservice;
	
	@MockBean
	IAdminRepository adminrepo;
	
	AdminDTO admin=null;
	AdminDTO admin1 =null;
	
	@BeforeEach
	public void testBeforeEach() 
	{
		
		admin = new AdminDTO();
		admin.setUsername("Yami");
		admin.setPassword("yami71");
		admin.setMobileNumber("67676653111");
		admin.setAddress("Hyderabad");
		admin.setEmail("abc@gmail.com");
		admin.setAdminId(1);
		
		admin1 = new AdminDTO();
		admin1.setUsername("Pavi");
		admin1.setPassword("pavi71");
		admin1.setMobileNumber("9859367281");
		admin1.setAddress("Hyderabad");
		admin1.setEmail("pavi@gmail.com");
		admin1.setAdminId(2);
		
	}
	@Test
	void testGetAll() throws AdminNotFoundException {
		
		List<Admin> adminList=new ArrayList<>();
		adminList.add(Converter.convertToEntity(admin));
		adminList.add(Converter.convertToEntity(admin1));
		
		Mockito.when(adminrepo.findAll()).thenReturn(adminList);
		assertNotNull(adminservice.getAll());
	}

	@Test
	void testGetById() {
		
		Admin admind=Converter.convertToEntity(admin);
		Optional<Admin> driver2=Optional.of(admind);
		Mockito.when(adminrepo.findById(1)).thenReturn(driver2);
		assertThat(adminrepo.existsById(admin.getAdminId()));
		
	}

	@Test
	void testGetByCustomerId() 
	{
		
		
	}

	@Test
	void testGetTripsCabwise() {
		
	}

	@Test
	void testSave() throws Throwable {
		
		Admin admind=Converter.convertToEntity(admin1);
		Mockito.when(adminrepo.save(admind)).thenReturn(admind);
		assertThat(adminservice.save(admin1)).isEqualTo(admin1);
		
	}

	@Test
	void testUpdate() throws Throwable {
		
		Admin admind=Converter.convertToEntity(admin1);
		Optional<Admin> admin2=Optional.of(admind);
		Mockito.when(adminrepo.findById(1)).thenReturn(admin2);
		Mockito.when(adminrepo.save(admind)).thenReturn(admind);
		equals(adminservice.save(admin1));
		
	}

	@Test
	void testDelete() {

		Admin admind=Converter.convertToEntity(admin);
		Optional<Admin> admin2=Optional.of(admind);
		
		Mockito.when(adminrepo.findById(1)).thenReturn(admin2);
		Mockito.when(adminrepo.existsById(admin.getAdminId())).thenReturn(false);
		assertFalse(adminrepo.existsById(admin.getAdminId()));
		
	}

	@Test
	void testGetTripsDatewise() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTripsCustomerwise() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllTripsForDays() {
		fail("Not yet implemented");
	}

}
