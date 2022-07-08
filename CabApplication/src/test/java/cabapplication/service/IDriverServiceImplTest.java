package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.dto.DriverDTO;
import cabapplication.entity.Driver;
import cabapplication.exception.DriverNotFoundException;
import cabapplication.repository.IDriverRepository;
import cabapplication.utils.Converter;
@SpringBootTest
class IDriverServiceImplTest {
	@Autowired
	IDriverServiceImpl driverservice;
	@Autowired
	static Converter converter;
	
	@MockBean
	IDriverRepository driverrepo;

	@Test
	void testGetAll() throws Throwable 
	{
		
		DriverDTO driver=new DriverDTO(); 
		driver.setUsername("Yami");
		driver.setPassword("yami71");
		driver.setMobileNumber("67676653111");
		driver.setAddress("Hyderabad");
		driver.setDriverId(1);
		driver.setLicenceNo("23d34d");
		driver.setRating(4.5);
		driver.setCab(null);
		
		DriverDTO driver1=new DriverDTO(); 
		driver1.setUsername("Harshi");
		driver1.setPassword("harshi8");
		driver1.setMobileNumber("7987879322");
		driver1.setAddress("Banglore");
		driver1.setLicenceNo("9777gf");
		driver.setDriverId(2);
		driver1.setRating(4.0);
		driver1.setCab(null);
		
		List<Driver> driverList=new ArrayList<>();
		driverList.add(Converter.convertDriverDtoToEntity(driver));
		driverList.add(Converter.convertDriverDtoToEntity(driver1));
		
		Mockito.when(driverrepo.findAll()).thenReturn(driverList);
		assertThat(driverservice.save(driver1)).isEqualTo(driverList);
		
	}
	
	@Test
	void testSave() throws Throwable
	{
		
		DriverDTO driver1=new DriverDTO();
		driver1.setUsername("Harshi");
		driver1.setPassword("harshi8");
		driver1.setMobileNumber("7987879322");
		driver1.setAddress("Banglore");
		driver1.setDriverId(1);
		driver1.setLicenceNo("9777gf");
		driver1.setRating(4.0);
		driver1.setCab(null);
	
		Driver driverd=Converter.convertDriverDtoToEntity(driver1);
		Mockito.when(driverrepo.save(driverd)).thenReturn(driverd);
		
		assertThat(driverservice.save(driver1)).isEqualTo(driver1);
		
	}
	
	@Test
	void testUpdate() throws Throwable
	{
		DriverDTO driver1=new DriverDTO();
		driver1.setUsername("Harshi");
		driver1.setPassword("Harshi");
		driver1.setMobileNumber("7987879322");
		driver1.setAddress("Banglore");
		driver1.setDriverId(1);
		driver1.setLicenceNo("9777gf");
		driver1.setRating(4.0);
		driver1.setCab(null);
		Driver driverd=Converter.convertDriverDtoToEntity(driver1);
		Optional<Driver> driver2=Optional.of(driverd);
		Driver driver=Converter.convertDriverDtoToEntity(driver1);
		Mockito.when(driverrepo.findById(1)).thenReturn(driver2);
		Mockito.when(driverrepo.save(driver)).thenReturn(driver);
		driver1.setUsername("Yami");
		driver1.setPassword("yami");
		driver1.setMobileNumber("7987879322");
		driver1.setAddress("Banglore");
		driver1.setLicenceNo("9777gf");
		driver1.setRating(4.0);
		driver1.setCab(null);
		assertThat(driverservice.update(driver1)).isEqualTo(driver1);
	}

	

}
