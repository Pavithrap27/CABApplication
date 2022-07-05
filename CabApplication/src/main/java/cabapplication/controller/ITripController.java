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

import cabapplication.entity.TripBooking;
import cabapplication.repository.ITripRepository;
import cabapplication.service.ITripService;

@RestController
@RequestMapping("tripbooking")
public class ITripController {
	@Autowired
	ITripService tripservice;

	@GetMapping("viewAllTrips")
	public List<TripBooking> viewAllTrips() {
		return tripservice.viewAllTrips();
	}

	@GetMapping("viewAllBookings/{tripBookingId}")
	public TripBooking viewTripBooking(@PathVariable int tripBookingId) {
		return tripservice.viewTripBooking(tripBookingId);
	}

	@PostMapping("insertTripBooking")
	public TripBooking insertTripBooking(@RequestBody TripBooking tripBooking) {
		tripservice.insertTripBooking(tripBooking);
		return tripBooking;
	}

	@PutMapping("updateTripBooking")
	public TripBooking updateTripBooking(@RequestBody TripBooking tripBooking) {
		TripBooking tripBookingupdated = tripservice.updateTripBooking(tripBooking);
		return tripBookingupdated;
	}

	@DeleteMapping("deleteTripBooking/{tripBookingId}")
	public String deleteTripBooking(@PathVariable int tripBookingId) {
		tripservice.deleteTripBooking(tripBookingId);
		return "Deleted";
	}

	@GetMapping("viewAllTrips/{customerId}")
	public List<TripBooking> viewAllTrips(@PathVariable int customerId) {
		List<TripBooking> trips = tripservice.viewAllTrips(customerId);
		return trips;

	}

	@GetMapping("calculateBill/{customerId}")
	public float calculateBill(@PathVariable int customerId) {
		float bill = tripservice.calculateBill(customerId);
		return bill;
	}

}
