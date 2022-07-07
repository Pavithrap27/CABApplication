package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.dto.DriverDTO;
import cabapplication.entity.Driver;
import cabapplication.exception.DriverNotFoundException;

public interface IDriverService {
	
	public List<DriverDTO> getAll() throws DriverNotFoundException;
	
	public DriverDTO save(DriverDTO driverDto)throws Throwable;
	
	public DriverDTO update(DriverDTO driver)throws Throwable;
	
	public String delete(int driverId)throws Throwable;
	
	public List<DriverDTO> viewBestDrivers()throws DriverNotFoundException;
	
	
	public DriverDTO getById(int driverid)throws Throwable;

	

}
