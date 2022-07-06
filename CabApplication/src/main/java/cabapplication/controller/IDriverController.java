package cabapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.Driver;
import cabapplication.exception.DriverNotFoundException;
import cabapplication.service.IDriverServiceImpl;

@RestController
@RequestMapping("driver")
public class IDriverController {

	
	IDriverServiceImpl driverservice;

	@GetMapping("/getdriver")
	public ResponseEntity<List<Driver>> getDriver() throws DriverNotFoundException 
	{
		return new ResponseEntity<>(driverservice.getDriver(),HttpStatus.OK);
	}

	@PostMapping(path = "/insertdriver")
	public ResponseEntity<Driver> insertDriver(@RequestBody Driver driver) throws DriverNotFoundException 
	{
		return new ResponseEntity<>(driverservice.insertDriver(driver),HttpStatus.OK);
		
	}

	@PutMapping(path = "/updatedriver")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) throws DriverNotFoundException 
	{
		return new ResponseEntity<>(driverservice.updateDriver(driver),HttpStatus.OK);
		
	}

	@DeleteMapping(path = "/deletedriver/{driverId}")
	public ResponseEntity<String> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException  
	{
		return new ResponseEntity<>(driverservice.deleteDriver(driverId),HttpStatus.OK);
		
	}

	@GetMapping(path = "/viewbestdrivers")
	public ResponseEntity<Driver> viewBestDrivers() throws DriverNotFoundException 
	{
		return new ResponseEntity<>((Driver) driverservice.viewBestDrivers(),HttpStatus.OK);
		
	}

	@GetMapping(path = "/viewdriver/{driverid}")
	public ResponseEntity<Driver> viewDriver(@PathVariable int driverid) throws DriverNotFoundException 
	{
		return new ResponseEntity<>(driverservice.viewDriver(driverid),HttpStatus.OK);
	}
}
