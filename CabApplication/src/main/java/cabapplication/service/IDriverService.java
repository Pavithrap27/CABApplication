package cabapplication.service;

import java.util.List;
import cabapplication.dto.DriverDTO;
import cabapplication.exception.DriverNotFoundException;

public interface IDriverService 
{
	
	public List<DriverDTO> getAll() throws DriverNotFoundException;
	
	public DriverDTO save(DriverDTO driverDto)throws DriverNotFoundException;
	
	public DriverDTO update(DriverDTO driver)throws DriverNotFoundException;
	
	public String delete(int driverId)throws DriverNotFoundException;
	
	public List<DriverDTO> viewBestDrivers()throws DriverNotFoundException;
	
	public DriverDTO getById(int driverid)throws DriverNotFoundException;

}
