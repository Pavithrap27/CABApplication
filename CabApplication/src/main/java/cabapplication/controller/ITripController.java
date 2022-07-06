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

import cabapplication.entity.TripBooking;
import cabapplication.repository.ITripRepository;
import cabapplication.service.ITripService;

@RestController
@RequestMapping("tripbooking")
public class ITripController {
	@Autowired
	ITripService tripservice;

	@GetMapping("viewAllTrips")
	public ResponseEntity<List<TripBooking>> viewAllTrips() throws Throwable {
		List<TripBooking> trips = tripservice.viewAllTrips();
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
		return response;
	}

	@GetMapping("viewAllBookings/{tripBookingId}")
	public ResponseEntity<TripBooking> viewTripBooking(@PathVariable int tripBookingId) throws Throwable {
		ResponseEntity<TripBooking> response = new ResponseEntity<TripBooking>(
				tripservice.viewTripBooking(tripBookingId), HttpStatus.OK);
		return response;
	}

	@PostMapping("insertTripBooking")
	public ResponseEntity<TripBooking> insertTripBooking(@RequestBody TripBooking tripBooking) throws Throwable {
		ResponseEntity<TripBooking> response = new ResponseEntity<TripBooking>(
				tripservice.insertTripBooking(tripBooking), HttpStatus.OK);
		return response;
	}

	@PutMapping("updateTripBooking")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripBooking) throws Throwable {
		TripBooking tripBookingupdated = tripservice.updateTripBooking(tripBooking);
		ResponseEntity<TripBooking> response = new ResponseEntity<TripBooking>(tripBookingupdated, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("deleteTripBooking/{tripBookingId}")
	public ResponseEntity<String> deleteTripBooking(@PathVariable int tripBookingId) throws Throwable {
		tripservice.deleteTripBooking(tripBookingId);
		ResponseEntity<String> response = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return response;
	}

	@GetMapping("viewAllTrips/{customerId}")
	public ResponseEntity<List<TripBooking>> viewAllTrips(@PathVariable int customerId) throws Throwable {
		List<TripBooking> trips = tripservice.viewAllTrips(customerId);
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
		return response;

	}

	@GetMapping("calculateBill/{customerId}")
	public ResponseEntity<Float> calculateBill(@PathVariable int customerId) throws Throwable {
		float bill = tripservice.calculateBill(customerId);
		ResponseEntity<Float> response = new ResponseEntity<Float>(bill, HttpStatus.OK);
		return response;
	}

}
