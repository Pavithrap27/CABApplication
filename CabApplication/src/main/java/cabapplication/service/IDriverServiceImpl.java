package cabapplication.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cabapplication.dto.DriverDTO;
import cabapplication.entity.Driver;
import cabapplication.exception.DriverNotFoundException;
import cabapplication.repository.IDriverRepository;
import cabapplication.utils.Converter;

@Service
@Transactional
public class IDriverServiceImpl implements IDriverService
{

	@Autowired
	IDriverRepository driverrepo;
	
	String message="Driver not found";
	@Override
	public List<DriverDTO> getAll() throws DriverNotFoundException
	{
		List<DriverDTO> driverDtoList=new ArrayList<>();
		Iterable<Driver> drivers=driverrepo.findAll();
		if (drivers==null) {
			throw new DriverNotFoundException(message);
		} 
		else {
			for(Driver driver:drivers) {
				driverDtoList.add(Converter.convertDriverToDTO(driver));
			}
			return driverDtoList;
		}
		
	}
	
	@Override
	public DriverDTO save(DriverDTO driverDto) throws DriverNotFoundException 
	{
		if (driverDto == null) {
			throw new DriverNotFoundException(message);
		} else {
			driverrepo.save(Converter.convertDriverDtoToEntity(driverDto));
			return driverDto;
		}
	}
	@Override
	public DriverDTO update(DriverDTO driverDto) throws DriverNotFoundException
	{
		if (driverDto == null) {
			throw new DriverNotFoundException(message);
		} 
		else 
		{
			Driver driver=Converter.convertDriverDtoToEntity(driverDto);
			int id = driver.getDriverId();
			Driver driverupdated = driverrepo.findById(id).orElseThrow();
			driverupdated.setUsername(driver.getUsername());
			driverupdated.setPassword(driver.getPassword());
			driverupdated.setMobileNumber(driver.getMobileNumber());
			driverupdated.setEmail(driver.getEmail());
			driverupdated.setLicenceNo(driver.getLicenceNo());
			driverupdated.setCab(driver.getCab());
			driverupdated.setRating(driver.getRating());
			driverupdated.setAddress(driver.getAddress());
			driverrepo.save(driverupdated);
			return Converter.convertDriverToDTO(driverupdated);
		}
	}
	@Override
	public String delete(int driverId) throws DriverNotFoundException
	{
		DriverDTO driver = Converter.convertDriverToDTO(driverrepo.findById(driverId).orElseThrow());
		if(driver==null)
		{
			throw new DriverNotFoundException(message);
		}
		else {
			driverrepo.deleteById(driverId);
			return "Deleted";
		}
		
	}
	
	@Override
	public List<DriverDTO> viewBestDrivers()  throws DriverNotFoundException
	{
		List<DriverDTO> driverDtoList=new ArrayList<>();
		List<Driver> drivers=driverrepo.viewBestDrivers();
		if (drivers.isEmpty()) {
			throw new DriverNotFoundException(message);
		} 
		else {
			for(Driver driver:drivers) {
				driverDtoList.add(Converter.convertDriverToDTO(driver));
			}
			return driverDtoList;
		}
		
	}
	
	@Override
	public DriverDTO getById(int driverid) throws DriverNotFoundException 
	{
		DriverDTO driverDto=Converter.convertDriverToDTO(driverrepo.findById(driverid).orElseThrow());
		if(driverDto==null) 
		{
			throw new DriverNotFoundException(message);
		}
		else {
			return driverDto;
		}
		
	}

	
}