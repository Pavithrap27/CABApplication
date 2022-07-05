package cabapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.TripBooking;
import cabapplication.repository.ITripRepository;
import cabapplication.service.ITripService;

@RestController
@RequestMapping("/tripbooking")
public class ITripController {
	@Autowired
	 ITripService tripservice;
	
	public List<TripBooking> viewAllTrips() {
		return tripservice.viewAllTrips();
	}
	
	public TripBooking viewTripBooking(int tripBookingId) {
		return tripservice.viewTripBooking(tripBookingId);
	}
	
	public TripBooking insertTripBooking(TripBooking tripBooking)
	{
		tripservice.insertTripBooking(tripBooking);
		return tripBooking;
	}
	
	public TripBooking updateTripBooking(TripBooking tripBooking)
	{
	    TripBooking tripBookingupdated=tripservice.updateTripBooking(tripBooking);
	    return tripBookingupdated;		
	}
	
	public String deleteTripBooking(int tripBookingId)
	{
		tripservice.deleteTripBooking(tripBookingId);
		return "Deleted";
	}
	
	public List<TripBooking> viewAllTrips(int customerId)
	{
		List<TripBooking> trips = tripservice.viewAllTrips(customerId);
		return trips;
		
	}
	
	public TripBooking calculateBill(int customerId)
	{
		TripBooking trip=tripservice.calculateBill(customerId);
		return trip;
	}

}
