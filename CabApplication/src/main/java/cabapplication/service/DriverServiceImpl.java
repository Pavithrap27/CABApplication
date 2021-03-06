package cabapplication.service;


import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cabapplication.dto.DriverDTO;
import cabapplication.entity.Driver;
import cabapplication.exception.DriverNotFoundException;
import cabapplication.repository.IDriverRepository;
import cabapplication.utils.Converter;

@Service
public class DriverServiceImpl implements IDriverService
{

	@Autowired
	IDriverRepository driverrepo;
	
	public String message="Driver not found";
	@Override
	public List<DriverDTO> getAll() throws DriverNotFoundException
	{
		List<Driver> driverList=driverrepo.findAll();
		if (driverList.isEmpty()) {
			throw new DriverNotFoundException(message);
		} 
		else {
				return Converter.convertDriverToDTO(driverList);
			}
		
	}
	
	@Override
	public DriverDTO save(DriverDTO driverDto) throws DriverNotFoundException
	{
		if(driverDto.getUsername()!=null)
		{
			driverrepo.save(Converter.convertDriverDtoToEntity(driverDto));
			return driverDto;
		}
		throw new DriverNotFoundException("Driver not available");
		
	}
	@Override
	public DriverDTO update(DriverDTO driverDto) throws DriverNotFoundException
	{
		
		Driver driver=Converter.convertDriverDtoToEntity(driverDto);
        int id = driver.getDriverId();
        Supplier<DriverNotFoundException> s1=()->new DriverNotFoundException("Driver not found");

        Driver driverupdated = driverrepo.findById(id).orElseThrow(s1);
        driverupdated.setUsername(driver.getUsername());
        driverupdated.setPassword(driver.getPassword());
        driverupdated.setMobileNumber(driver.getMobileNumber());
        driverupdated.setEmail(driver.getEmail());
        driverupdated.setLicenceNo(driver.getLicenceNo());
        driverupdated.setCab(driver.getCab());
        driverupdated.setRating(driver.getRating());
        driverupdated.setAddress(driver.getAddress());
        driverupdated.setTrips(driver.getTrips());
        driverrepo.save(driverupdated);
        return Converter.convertDriverToDTO(driverupdated);
		}

	@Override
	public String delete(int driverId) throws DriverNotFoundException
	{
		Supplier<DriverNotFoundException> s1=()->new DriverNotFoundException("Driver not found");
		
		driverrepo.findById(driverId).orElseThrow(s1);
		
		driverrepo.deleteById(driverId);
		return "Deleted";
	}
	
	@Override
	public List<DriverDTO> viewBestDrivers()  throws DriverNotFoundException
	{
		List<Driver> drivers=driverrepo.viewBestDrivers();
		if (drivers.isEmpty()) {
			throw new DriverNotFoundException(message);
		} 
		else {
			return Converter.convertDriverToDTO(drivers);
		}
		
	}
	
	@Override
	public DriverDTO getById(int driverid) throws DriverNotFoundException 
	{
		
		Supplier<DriverNotFoundException> s1=()->new DriverNotFoundException("driver not found");
		return Converter.convertDriverToDTO(driverrepo.findById(driverid).orElseThrow(s1));
		
	}

}