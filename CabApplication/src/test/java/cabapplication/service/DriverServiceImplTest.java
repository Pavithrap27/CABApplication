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

import cabapplication.dto.CabDTO;
import cabapplication.dto.DriverDTO;
import cabapplication.entity.Driver;
import cabapplication.exception.DriverNotFoundException;
import cabapplication.repository.IDriverRepository;
import cabapplication.utils.Converter;
@SpringBootTest
class DriverServiceImplTest {
	@Autowired
	DriverServiceImpl driverservice;
	@Autowired
	static Converter converter;
	
	@MockBean
	IDriverRepository driverrepo;
	
	CabDTO cab=null;
	DriverDTO driver=null;
	DriverDTO driver1=null;
	@BeforeEach
	public void testBeforeEach() {
		
		cab=new CabDTO();
		driver=new DriverDTO();
		driver1 = new DriverDTO();
		cab.setCabId(1);
		cab.setCarType("Honda");
		cab.setPerKmRate(11.5f);
		
		driver.setUsername("Yami");
		driver.setPassword("yami71");
		driver.setMobileNumber("67676653111");
		driver.setAddress("Hyderabad");
		driver.setDriverId(1);
		driver.setLicenceNo("23d34d");
		driver.setRating(4.5);
		driver.setCab(null);
		
		driver1.setUsername("Harshi");
		driver1.setPassword("harshi8");
		driver1.setMobileNumber("7987879322");
		driver1.setAddress("Banglore");
		driver1.setLicenceNo("9777gf");
		driver.setDriverId(2);
		driver1.setRating(4.0);
		driver.setCab(null);
		
	}
	

	@Test
	void testGetAll() throws Throwable 
	{

		List<Driver> driverList=new ArrayList<>();
		driverList.add(Converter.convertDriverDtoToEntity(driver));
		driverList.add(Converter.convertDriverDtoToEntity(driver1));
		
		Mockito.when(driverrepo.findAll()).thenReturn(driverList);
		assertNotNull(driverservice.getAll());
		
		
	}
	
	@Test
	void testSave() throws Throwable
	{
		
		Driver driverd=Converter.convertDriverDtoToEntity(driver1);
		Mockito.when(driverrepo.save(driverd)).thenReturn(driverd);
		assertThat(driverservice.save(driver1)).isEqualTo(driver1);
		
	}
	
	@Test
	void testUpdate() throws Throwable
	{
		
		Driver driverd=Converter.convertDriverDtoToEntity(driver1);
		Optional<Driver> driver2=Optional.of(driverd);
		Driver driver=Converter.convertDriverDtoToEntity(driver1);
		Mockito.when(driverrepo.findById(1)).thenReturn(driver2);
		Mockito.when(driverrepo.save(driver)).thenReturn(driver);
		equals(driverservice.save(driver1));
		
	}
	
	@Test
	void testDelete() {
		
		Driver driverd=Converter.convertDriverDtoToEntity(driver);
		Optional<Driver> driver2=Optional.of(driverd);
		
		Mockito.when(driverrepo.findById(1)).thenReturn(driver2);
		Mockito.when(driverrepo.existsById(driver.getDriverId())).thenReturn(false);
		assertFalse(driverrepo.existsById(driver.getDriverId()));
	}
	
	@Test
	void testViewBestDrivers() throws DriverNotFoundException
	{
		
		List<Driver> driverList=new ArrayList<>();
		driverList.add(Converter.convertDriverDtoToEntity(driver));
		driverList.add(Converter.convertDriverDtoToEntity(driver1));
		Mockito.when(driverrepo.viewBestDrivers()).thenReturn(driverList);
		assertNotNull(driverservice.viewBestDrivers());
		
	}
	@Test
	void getById() {
		
		Driver driverd=Converter.convertDriverDtoToEntity(driver);
		Optional<Driver> driver2=Optional.of(driverd);
		Mockito.when(driverrepo.findById(1)).thenReturn(driver2);
		assertThat(driverrepo.existsById(driver.getDriverId()));
		
	}
	

}
