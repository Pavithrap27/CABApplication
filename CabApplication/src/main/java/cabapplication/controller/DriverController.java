package cabapplication.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import cabapplication.exception.DriverNotFoundException;
import cabapplication.service.DriverServiceImpl;

@RestController
@RequestMapping("driver")
public class DriverController {
	
	Log logger = LogFactory.getLog(DriverController.class);

	@Autowired
	DriverServiceImpl driverservice;

	/* Retrieve all the elements */
	@GetMapping("/getAll")
	public ResponseEntity<List<DriverDTO>> getAll() throws DriverNotFoundException {
		logger.info("getting elements from getall");
		List<DriverDTO> driver = driverservice.getAll();
		return new ResponseEntity<>(driver, HttpStatus.OK);
	}

	/* Saves all the elements given as an input */
	@PostMapping(path = "/save")
	public ResponseEntity<DriverDTO> save(@RequestBody DriverDTO driver) throws Throwable {
		logger.info("saving the elements");
		return new ResponseEntity<>(driverservice.save(driver), HttpStatus.OK);

	}

	/* Updates the elements according to corresponding input */
	@PutMapping(path = "/update")
	public ResponseEntity<DriverDTO> update(@RequestBody DriverDTO driver) throws Throwable {
		logger.info("updating elements");
		return new ResponseEntity<>(driverservice.update(driver), HttpStatus.OK);

	}

	/* Delete the element based on the id given as an input */
	@DeleteMapping(path = "/deleteById/{driverId}")
	public ResponseEntity<String> delete(@PathVariable int driverId) throws Throwable {
		logger.info("Deleting elements ");
		return new ResponseEntity<>(driverservice.delete(driverId), HttpStatus.OK);

	}

	/* Retrieve all the elements that are greater than 4.5 */
	@GetMapping(path = "/viewBestDrivers")
	public ResponseEntity<List<DriverDTO>> viewBestDrivers() throws DriverNotFoundException {
		logger.info("getting all the elements which are greater than 4.5 ");
		return new ResponseEntity<>(driverservice.viewBestDrivers(), HttpStatus.OK);

	}

	/* Retrieve elements according to the id as an input */
	@GetMapping(path = "/getById/{driverid}")
	public ResponseEntity<DriverDTO> getById(@PathVariable int driverid) throws Throwable {
		logger.info("getting the element based on the Id");
		return new ResponseEntity<>(driverservice.getById(driverid), HttpStatus.OK);
	}
}
