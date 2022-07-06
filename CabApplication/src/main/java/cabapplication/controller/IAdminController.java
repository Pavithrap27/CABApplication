package cabapplication.controller;

import java.time.LocalDateTime;
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

import cabapplication.dto.AdminDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CabNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.service.IAdminService;

@RestController
@RequestMapping("admin")
public class IAdminController {
    @Autowired
	IAdminService adminservice;

	@GetMapping("getAdmin")
	public ResponseEntity<List<AdminDTO>> getAll() throws AdminNotFoundException {
		List<AdminDTO> admin = adminservice.getAll();
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}

	@PostMapping("insertAdmin")
	public ResponseEntity<AdminDTO> save(@RequestBody AdminDTO admin) throws AdminNotFoundException {
		return new ResponseEntity<>(adminservice.save(admin), HttpStatus.OK);
		
	}

	@PutMapping("updateAdmin")
	public ResponseEntity<AdminDTO> update(@RequestBody AdminDTO adminDto) throws AdminNotFoundException{
		 return new ResponseEntity<>(adminservice.updateAdmin(adminDto), HttpStatus.OK);
		
	}

	@DeleteMapping("deleteAdmin")
	public ResponseEntity<String> delete(@RequestBody AdminDTO adminDto) throws AdminNotFoundException {
		adminservice.delete(adminDto);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@GetMapping("viewAdmin/{adminId}")
	public ResponseEntity<AdminDTO> getById(@PathVariable int adminId) throws AdminNotFoundException {
		return new ResponseEntity<>(adminservice.getById(adminId), HttpStatus.OK);
		
	}

	@GetMapping("getAllTrips/{customerId}")
	public ResponseEntity<List<TripBookingDTO>> getByCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
		List<TripBookingDTO> trips = adminservice.getAllTrips(customerId);
		return  new ResponseEntity<>(trips, HttpStatus.OK);

	}

	@GetMapping("getTripsCabwise")
	public ResponseEntity<List<TripBookingDTO>> getTripsCabwise() throws CabNotFoundException {
		List<TripBookingDTO> trips = adminservice.getTripsCabwise();
		return new ResponseEntity<>(trips, HttpStatus.OK);
		
	}

	@GetMapping("getTripsDatewise")
	public ResponseEntity<List<TripBookingDTO>> getTripsDatewise() throws TripNotFoundException {
		List<TripBookingDTO> trips = adminservice.getTripsDatewise();
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

	@GetMapping("getTripsCustomerwise")
	public ResponseEntity<List<TripBookingDTO>> getTripsCustomerwise() throws  CustomerNotFoundException {
		List<TripBookingDTO> trips = adminservice.getTripsCustomerwise();
		return new ResponseEntity<>(trips, HttpStatus.OK);
		
	}

	@GetMapping("getAllTripsForDays")
	public ResponseEntity<List<TripBookingDTO>> getAllTripsForDays(@PathVariable int customerId,
			@PathVariable LocalDateTime fromDate, @PathVariable LocalDateTime ToDate) throws CustomerNotFoundException{
		List<TripBookingDTO> trips = adminservice.getAllTripsForDays(customerId, fromDate, ToDate);
		return new ResponseEntity<>(trips, HttpStatus.OK);
		
	}
}
