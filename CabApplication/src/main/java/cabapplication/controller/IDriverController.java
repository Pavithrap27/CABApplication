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

import cabapplication.dto.DriverDTO;
import cabapplication.entity.Driver;
import cabapplication.exception.DriverNotFoundException;
import cabapplication.service.IDriverServiceImpl;

@RestController
@RequestMapping("driver")
public class IDriverController {

	@Autowired
	IDriverServiceImpl driverservice;

	@GetMapping("/getAll")
	public ResponseEntity<List<DriverDTO>> getAll() throws DriverNotFoundException 
	{
		List<DriverDTO> driver=driverservice.getAll();
		return new ResponseEntity<>(driver,HttpStatus.OK);
	}

	@PostMapping(path = "/save")
	public ResponseEntity<DriverDTO> save(@RequestBody DriverDTO driver) throws DriverNotFoundException 
	{
		return new ResponseEntity<>(driverservice.save(driver),HttpStatus.OK);
		
	}

	@PutMapping(path = "/update")
	public ResponseEntity<DriverDTO> update(@RequestBody DriverDTO driver) throws DriverNotFoundException 
	{
		return new ResponseEntity<>(driverservice.update(driver),HttpStatus.OK);
		
	}

	@DeleteMapping(path = "/deleteById/{driverId}")
	public ResponseEntity<String> delete(@PathVariable int driverId) throws DriverNotFoundException  
	{
		return new ResponseEntity<>(driverservice.delete(driverId),HttpStatus.OK);
		
	}

	@GetMapping(path = "/viewBestDrivers")
	public ResponseEntity<List<DriverDTO>> viewBestDrivers() throws DriverNotFoundException 
	{
		return new ResponseEntity<>( driverservice.viewBestDrivers(),HttpStatus.OK);
		
	}

	@GetMapping(path = "/getById/{driverid}")
	public ResponseEntity<DriverDTO> getById(@PathVariable int driverid) throws DriverNotFoundException 
	{
		return new ResponseEntity<>(driverservice.getById(driverid),HttpStatus.OK);
	}
}
