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
import cabapplication.exception.CabNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.service.IAdminServiceImpl;

@RestController
@RequestMapping("admin")

public class IAdminController {
	Log logger=LogFactory.getLog(IAdminController.class);
	@Autowired
	IAdminServiceImpl adminservice;

	@GetMapping("getAll")
	public ResponseEntity<List<AdminDTO>> getAll() throws AdminNotFoundException {
		List<AdminDTO> admin = adminservice.getAll();
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}

	@PostMapping("save")
	public ResponseEntity<AdminDTO> save(@RequestBody AdminDTO admin) throws Throwable {
		return new ResponseEntity<>(adminservice.save(admin), HttpStatus.OK);
	}

	@PutMapping("update")
	public ResponseEntity<AdminDTO> update(@RequestBody AdminDTO adminDto) throws Throwable {
		return new ResponseEntity<>(adminservice.update(adminDto), HttpStatus.OK);

	}

	@DeleteMapping("delete/{adminId}")
	public ResponseEntity<String> delete(@PathVariable int adminId) throws Throwable {
		adminservice.delete(adminId);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@GetMapping("getById/{adminId}")
	public ResponseEntity<AdminDTO> getById(@PathVariable int adminId) throws Throwable {
		return new ResponseEntity<>(adminservice.getById(adminId), HttpStatus.OK);

	}

	@GetMapping("getByCustomerId/{customerId}")
	public ResponseEntity<List<TripBookingDTO>> getByCustomerId(@PathVariable int customerId) throws Throwable {
		List<TripBookingDTO> trips = adminservice.getByCustomerId(customerId);
		return new ResponseEntity<>(trips, HttpStatus.OK);

	}


	
	@GetMapping("getTripsCabwise/{carType}")
	public ResponseEntity<List<TripBookingDTO>> getTripsCabwise(@PathVariable String carType) throws CabNotFoundException {
		return new ResponseEntity<>(adminservice.getTripsCabwise(carType), HttpStatus.OK);
	}

	@GetMapping("getTripsDatewise")
	public ResponseEntity<List<TripBookingDTO>> getTripsDatewise() throws TripNotFoundException {
		List<TripBookingDTO> trips = adminservice.getTripsDatewise();
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

	@GetMapping("getTripsCustomerwise")
	public ResponseEntity<List<TripBookingDTO>> getTripsCustomerwise() throws CustomerNotFoundException {
		List<TripBookingDTO> trips = adminservice.getTripsCustomerwise();
		return new ResponseEntity<>(trips, HttpStatus.OK);

	}

	@GetMapping("getAllTripsForDays/{customerId}/{fromDate}/{toDate}")
	public ResponseEntity<List<TripBookingDTO>> getAllTripsForDays(@PathVariable int customerId,
			@PathVariable LocalDateTime fromDate, @PathVariable LocalDateTime toDate) throws CustomerNotFoundException {
		List<TripBookingDTO> trips = adminservice.getAllTripsForDays(customerId, fromDate, toDate);
		return new ResponseEntity<>(trips, HttpStatus.OK);

	}
}
