package cabapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Driver;
import cabapplication.repository.IDriverRepository;

@Service
public class IDriverService {
	
	@Autowired
	IDriverRepository driverrepo;
	
	public List<Driver> getDriver()
	{
		return driverrepo.findAll();
	}
	public Driver insertDriver(Driver driver)
	{
		return  driverrepo.save(driver);
	}
	public Driver updateDriver(Driver driver)
	{
		int id=driver.getDriverId();
		Driver d= driverrepo.findById(id).orElseThrow();
		d.setUsername(driver.getUsername());
		d.setPassword(driver.getPassword());
		d.setMobileNumber(driver.getMobileNumber());
		d.setEmail(driver.getEmail());
		d.setLicenceNo(driver.getLicenceNo());
		d.setCab(driver.getCab());
		d.setRating(driver.getRating());
		d.setAddress(driver.getAddress());
		driverrepo.save(d);
		return d;
	}
	public String deleteDriver(int driverId)
	{
		Driver d=driverrepo.findById(driverId).orElseThrow();
		driverrepo.deleteById(driverId);
		return "Deleted";	
	}
	public List<Driver> viewBestDrivers()
	{ 
		List<Driver> lc=driverrepo.viewBestDrivers();
		return lc;
		
	}
	public Driver viewDriver(int driverid)
	{
		return driverrepo.findById(driverid).orElseThrow();
	}

}
