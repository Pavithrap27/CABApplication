package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
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
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.IAdminRepository;
import cabapplication.repository.ITripRepository;
import cabapplication.utils.Converter;

@SpringBootTest
class AdminServiceImplTest {

	
	@Autowired
	AdminServiceImpl adminService;
	
	@Autowired
	TripServiceImpl tripService;
	@MockBean
	ITripRepository tripRepo;
	
	@MockBean
	IAdminRepository adminRepo;
	
	AdminDTO admin=null;
	AdminDTO admin1 =null;
	
	TripBookingDTO tripDto1=null;
	TripBookingDTO tripDto2=null;
	
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
		
		tripDto1 = new TripBookingDTO();
		tripDto1.setTripBookingId(1);
		tripDto1.setBill(100);
		tripDto1.setCustomerId(1);
		tripDto1.setDistanceInKm(90);
		tripDto1.setFromLocation("banaglore");
		tripDto1.setStatus(true);
		tripDto1.setToLocation("goa");
		tripDto1.setFromDateTime(LocalDateTime.now());
		tripDto1.setToDateTime(LocalDateTime.of(2022, 02, 01, 05, 04));
		
		tripDto2 = new TripBookingDTO();
		tripDto2.setTripBookingId(2);
		tripDto2.setBill(90);
		tripDto2.setCustomerId(2);
		tripDto2.setDistanceInKm(80);
		tripDto2.setFromLocation("mymbai");
		tripDto2.setStatus(true);
		tripDto2.setToLocation("goa");
		tripDto2.setFromDateTime(LocalDateTime.of(2022, 03, 01, 05, 04));
		tripDto2.setToDateTime(LocalDateTime.of(2022, 05, 01, 05, 04));
		
	}
	@Test

	void testGetAll() throws AdminNotFoundException {
		
		List<Admin> adminList=new ArrayList<>();
		adminList.add(Converter.convertToEntity(admin));
		adminList.add(Converter.convertToEntity(admin1));
		
		Mockito.when(adminRepo.findAll()).thenReturn(adminList);
		assertNotNull(adminService.getAll());
	}

	@Test
	void testGetById() {
		
		Admin admind=Converter.convertToEntity(admin);
		Optional<Admin> driver2=Optional.of(admind);
		Mockito.when(adminRepo.findById(1)).thenReturn(driver2);
		assertThat(adminRepo.existsById(admin.getAdminId()));
		
	}

	@Test
	void testGetByCustomerId() throws CustomerNotFoundException 
	{
		List<TripBookingDTO> tripBooking = new ArrayList<>();
		tripBooking.add(tripDto1);
		tripBooking.add(tripDto2);
		List<TripBooking> list = Converter.convertTripToEntity(tripBooking);
		Mockito.when(tripRepo.getByCustomerId(1)).thenReturn(list);
		equals(tripService.getByCustomerId(1));
		
	}

	@Test
	void testSave() throws Throwable {
		
		Admin admind=Converter.convertToEntity(admin1);
		Mockito.when(adminRepo.save(admind)).thenReturn(admind);
		assertThat(adminService.save(admin1)).isEqualTo(admin1);
		
	}

	@Test
	void testUpdate() throws Throwable {
		
		Admin admind=Converter.convertToEntity(admin1);
		Optional<Admin> admin2=Optional.of(admind);
		Mockito.when(adminRepo.findById(1)).thenReturn(admin2);
		Mockito.when(adminRepo.save(admind)).thenReturn(admind);
		equals(adminService.save(admin1));
		
	}

	@Test
	void testDelete() {

		Admin admind=Converter.convertToEntity(admin);
		Optional<Admin> admin2=Optional.of(admind);
		Mockito.when(adminRepo.findById(1)).thenReturn(admin2);
		Mockito.when(adminRepo.existsById(admin.getAdminId())).thenReturn(false);
		assertFalse(adminRepo.existsById(admin.getAdminId()));
		
	}

	@Test
	void testGetTripsDatewise() throws TripNotFoundException 
	{
		List<TripBookingDTO> tripBooking = new ArrayList<>();
		tripBooking.add(tripDto1);
		tripBooking.add(tripDto2);
		List<TripBooking> list = Converter.convertTripToEntity(tripBooking);
		Mockito.when(tripRepo.getTripsDatewise()).thenReturn(list);
		assertNotNull(adminService.getTripsDatewise());
	}

	@Test
	void testGetTripsCustomerwise() throws CustomerNotFoundException 
	{
		List<TripBookingDTO> tripBooking = new ArrayList<>();
		tripBooking.add(tripDto1);
		tripBooking.add(tripDto2);
		List<TripBooking> list = Converter.convertTripToEntity(tripBooking);
		Mockito.when(tripRepo.getTripCustomerwise()).thenReturn(list);
		assertNotNull(adminService.getTripsCustomerwise());
	}

	@Test
	void testGetAllTripsForDays() throws CustomerNotFoundException
	{
		List<TripBookingDTO> tripBooking = new ArrayList<>();
		tripBooking.add(tripDto1);
		List<TripBooking> list = Converter.convertTripToEntity(tripBooking);
		Mockito.when(tripRepo.getAllTripsForDays(1, LocalDateTime.now(),LocalDateTime.of(2022, 02, 01, 05, 04) )).thenReturn(list);
		assertNotNull(adminService.getAllTripsForDays(1, LocalDateTime.now(),LocalDateTime.of(2022, 02, 01, 05, 04) ));
	}

}
