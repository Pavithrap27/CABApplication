package cabapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.Driver;
import cabapplication.service.IDriverService;

@RestController
@RequestMapping("driver")
public class IDriverController {

	@Autowired
	IDriverService driverservice;
	
	@GetMapping("/getdriver")
	public List<Driver> getDriver()
	{
		return driverservice.getDriver();
	}
	@PostMapping(path="/insertdriver")
	public Driver insertDriver(@RequestBody Driver driver)
	{
		return driverservice.insertDriver(driver);
	}
	@PutMapping(path="/updatedriver")
	public Driver updateDriver(@RequestBody Driver driver)
	{
		return driverservice.updateDriver(driver);
	}
	@DeleteMapping(path="/deletedriver/{driverId}")
	public String deleteDriver(@PathVariable int driverId)
	{
		return driverservice.deleteDriver(driverId);
	}
	@GetMapping(path="/viewbestdrivers")
	public List<Driver> viewBestDrivers()
	{
		return driverservice.viewBestDrivers();
	}
	@GetMapping(path="/viewdriver/{driverid}")
	public Driver viewDriver(@PathVariable int driverid)
	{
		return driverservice.viewDriver(driverid);
	}
}
