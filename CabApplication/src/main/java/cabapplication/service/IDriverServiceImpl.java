package cabapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Admin;
import cabapplication.entity.Driver;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.DriverNotFoundException;
import cabapplication.repository.IDriverRepository;

@Service
public class IDriverServiceImpl implements IDriverService
{

	@Autowired
	IDriverRepository driverrepo;

	public List<Driver> getDriver() throws DriverNotFoundException
	{
		List<Driver> driver = driverrepo.findAll();
		if (driver.isEmpty()) {
			throw new DriverNotFoundException("Driver not found");
		} else {
			return driver;
		}
	}

	public Driver insertDriver(Driver driver)throws DriverNotFoundException
	{
		if (driver == null) {
			throw new DriverNotFoundException("Driver not found");
		} else {
			driverrepo.save(driver);
			return driver;
		}
	}

	public Driver updateDriver(Driver driver) throws DriverNotFoundException
	{
		if (driver == null) {
			throw new DriverNotFoundException("Driver not found");
		} 
		else 
		{
			int id = driver.getDriverId();
			Driver d = driverrepo.findById(id).orElseThrow();
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
	}

	public String deleteDriver(int driverId) throws DriverNotFoundException
	{
		Driver driver = driverrepo.findById(driverId).orElseThrow();
		if(driver==null)
		{
			throw new DriverNotFoundException("Driver not found");
		}
		else {
			driverrepo.deleteById(driverId);
			return "Deleted";
		}
		
	}

	public List<Driver> viewBestDrivers()  throws DriverNotFoundException
	{
		List<Driver> driverlist = driverrepo.viewBestDrivers();
		if(driverlist.isEmpty()) 
		{
			throw new DriverNotFoundException("Driver not found");
		}
		else {
			return driverlist;
		}
	}

	public Driver viewDriver(int driverid) throws DriverNotFoundException 
	{
		Driver driver=driverrepo.findById(driverid).orElseThrow();
		if(driver==null) 
		{
			throw new DriverNotFoundException("Driver not found");
		}
		else {
			return driver;
		}
		
	}

}
