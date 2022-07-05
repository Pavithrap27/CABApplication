package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.TripBooking;
import cabapplication.repository.ITripRepository;

@Service
public class ITripService {
	@Autowired
	 ITripRepository triprepo;
	
	public TripBooking insertTripBooking(TripBooking tripBooking)
	{
		triprepo.save(tripBooking);
		return tripBooking;
	}
	public TripBooking updateTripBooking(TripBooking tripBooking)
	{
		int id=tripBooking.getTripBookingId();
		TripBooking tripBookingupdated=triprepo.findById(id).orElseThrow();
		tripBookingupdated.setDistanceInKm(tripBooking.getDistanceInKm());
		tripBookingupdated.setCustomerId(tripBooking.getCustomerId());
		tripBookingupdated.setBill(tripBooking.getBill());
		tripBookingupdated.setDriver(tripBooking.getDriver());
		tripBookingupdated.setFromDateTime(tripBooking.getFromDateTime());
		tripBookingupdated.setFromLocation(tripBooking.getFromLocation());
		tripBookingupdated.setToLocation(tripBooking.getToLocation());
		tripBookingupdated.setToDateTime(tripBooking.getToDateTime());
	    triprepo.save(tripBookingupdated);
	    return tripBookingupdated;		
	}
	public String deleteTripBooking(int tripBookingId)
	{
		triprepo.deleteById(tripBookingId);
		return "Deleted";
	}
	public List<TripBooking> viewAllTrips(int customerId)
	{
		List<TripBooking> trips = triprepo.viewAllTrips(customerId);
		return trips;
		
	}
	public TripBooking calculateBill(int customerId)
	{
		int km=30;
		float bill=0.0f;
		TripBooking trip=triprepo.findById(customerId).orElseThrow();
		if(trip.getDistanceInKm()>2)
		{
		    bill =(trip.getDistanceInKm()*30);
		}
		else
		{
			bill=30.0f;
		}
		trip.setBill(bill);
		triprepo.save(trip);
		return trip;
	}
	
	
	
	
	

}
