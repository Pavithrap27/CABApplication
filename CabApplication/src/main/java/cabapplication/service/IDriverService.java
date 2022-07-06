package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.entity.Driver;
import cabapplication.exception.DriverNotFoundException;
@Service
public interface IDriverService {
	
	public List<Driver> getDriver() throws DriverNotFoundException;
	public Driver insertDriver(Driver driver)throws DriverNotFoundException;
	public Driver updateDriver(Driver driver)throws DriverNotFoundException;
	public String deleteDriver(int driverId)throws DriverNotFoundException;
	public List<Driver> viewBestDrivers()throws DriverNotFoundException;
	public Driver viewDriver(int driverid)throws DriverNotFoundException;

}
