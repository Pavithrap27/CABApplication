package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.entity.TripBooking;


@Service
public interface ITripService {
	
	public List<TripBooking> viewAllTrips();
	public TripBooking viewTripBooking(int tripBookingId);
	public TripBooking updateTripBooking(TripBooking tripBooking);
	public String deleteTripBooking(int tripBookingId);
	public List<TripBooking> viewAllTrips(int customerId);
	public double calculateBill(int customerId);

}
