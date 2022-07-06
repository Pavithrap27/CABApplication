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

import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.service.IAdminServiceImpl;
import cabapplication.service.ITripServiceImpl;

@RestController
@RequestMapping("admin")
public class IAdminController 
{	
	
	IAdminServiceImpl adminservice;
	@GetMapping("getAdmin")
	public ResponseEntity<List<Admin>> getAdmin() throws Throwable {
		List<Admin> admin = (List<Admin>) adminservice.getAdmin();
		ResponseEntity<List<Admin>> response = new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
		return response;
	}

	@PostMapping("insertAdmin")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin) throws Throwable {
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(adminservice.insertAdmin(admin), HttpStatus.OK);
		return response;
	}

	@PutMapping("updateAdmin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) throws Throwable {
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(adminservice.updateAdmin(admin), HttpStatus.OK);
		return response;
	}

	@DeleteMapping("deleteAdmin")
	public ResponseEntity<String> deleteAdmin(@RequestBody Admin admin) throws Throwable {
		adminservice.deleteAdmin(admin);
		ResponseEntity<String> response = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return response;
	}

	@GetMapping("viewAdmin/{adminId}")
	public ResponseEntity<Admin> viewAdmin(@PathVariable int adminId) throws Throwable {
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(adminservice.viewAdmin(adminId), HttpStatus.OK);
		return response;
	}

	@GetMapping("getAllTrips/{customerId}")
	public ResponseEntity<List<TripBooking>> getAllTrips(@PathVariable int customerId) throws Throwable {
		List<TripBooking> trips = adminservice.getAllTrips(customerId);
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
		return response;

	}

	@GetMapping("getTripsCabwise")
	public ResponseEntity<List<TripBooking>> getTripsCabwise() throws Throwable {
		List<TripBooking> trips = adminservice.getTripsCabwise();
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
		return response;
	}

	@GetMapping("getTripsDatewise")
	public ResponseEntity<List<TripBooking>> getTripsDatewise() throws Throwable {
		List<TripBooking> trips = adminservice.getTripsDatewise();
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
		return response;
	}

	@GetMapping("getTripsCustomerwise")
	public ResponseEntity<List<TripBooking>> getTripsCustomerwise() throws Throwable {
		List<TripBooking> trips = adminservice.getTripsCustomerwise();
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
		return response;
	}

	@GetMapping("getAllTripsForDays")
	public ResponseEntity<List<TripBooking>> getAllTripsForDays(@PathVariable int customerId,
			@PathVariable LocalDateTime fromDate, @PathVariable LocalDateTime ToDate) throws Throwable {
		List<TripBooking> trips = adminservice.getAllTripsForDays(customerId, fromDate, ToDate);
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
		return response;
	}
}
