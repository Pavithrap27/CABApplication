package cabapplication.controller;

import java.time.LocalDateTime;
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
import cabapplication.dto.AdminDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.service.AdminServiceImpl;

@RestController
@RequestMapping("admin")

public class AdminController {
	Log logger = LogFactory.getLog(AdminController.class);
	@Autowired
	AdminServiceImpl adminservice;

	/* Retrieve all the elements */
	@GetMapping("getAll")
	public ResponseEntity<List<AdminDTO>> getAll() throws AdminNotFoundException {
		logger.info("getting elements from getall");
		List<AdminDTO> admin = adminservice.getAll();
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}

	/* Saves all the elements given as an input */
	@PostMapping("save")
	public ResponseEntity<AdminDTO> save(@RequestBody AdminDTO admin) throws Throwable {
		logger.info("saving the elements");
		return new ResponseEntity<>(adminservice.save(admin), HttpStatus.OK);
	}

	/* Updates the elements according to corresponding input */
	@PutMapping("update")
	public ResponseEntity<AdminDTO> update(@RequestBody AdminDTO adminDto) throws Throwable {
		logger.info("updating elements");
		return new ResponseEntity<>(adminservice.update(adminDto), HttpStatus.OK);

	}

	/* Delete the element based on the id given as an input */
	@DeleteMapping("delete/{adminId}")
	public ResponseEntity<String> delete(@PathVariable int adminId) throws Throwable {
		logger.info("Deleting elements ");
		adminservice.delete(adminId);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	/* Retrieve elements according to the id as an input */
	@GetMapping("getById/{adminId}")
	public ResponseEntity<AdminDTO> getById(@PathVariable int adminId) throws Throwable {
		logger.info("getting elements by id");
		return new ResponseEntity<>(adminservice.getById(adminId), HttpStatus.OK);

	}

	/* Retrieve elements according to the customer id as an input */
	@GetMapping("getByCustomerId/{customerId}")
	public ResponseEntity<List<TripBookingDTO>> getByCustomerId(@PathVariable int customerId) throws Throwable {
		logger.info("getting elements by customer id");
		List<TripBookingDTO> trips = adminservice.getByCustomerId(customerId);
		return new ResponseEntity<>(trips, HttpStatus.OK);

	}

	/* Retrieve elements according to date */
	@GetMapping("getTripsDatewise")
	public ResponseEntity<List<TripBookingDTO>> getTripsDatewise() throws TripNotFoundException {
		logger.info("getting elements date wise");
		List<TripBookingDTO> trips = adminservice.getTripsDatewise();
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

	/* Retrieve elements according to customer */
	@GetMapping("getTripsCustomerwise")
	public ResponseEntity<List<TripBookingDTO>> getTripsCustomerwise() throws CustomerNotFoundException {
		logger.info("getting elements customer wise");
		List<TripBookingDTO> trips = adminservice.getTripsCustomerwise();
		return new ResponseEntity<>(trips, HttpStatus.OK);

	}

	
	 /* Retrieve elements according to the customer id,from date ,to date as an input*/
	@GetMapping("getAllTripsForDays/{customerId}/{fromDate}/{toDate}")
	public ResponseEntity<List<TripBookingDTO>> getAllTripsForDays(@PathVariable int customerId,
			@PathVariable  String  fromDate, @PathVariable String toDate) throws CustomerNotFoundException {
		logger.info("getting elements for days ");
		List<TripBookingDTO> trips = adminservice.getAllTripsForDays(customerId, LocalDateTime.parse(fromDate),LocalDateTime.parse( toDate));
		return new ResponseEntity<>(trips, HttpStatus.OK);

	}
}
