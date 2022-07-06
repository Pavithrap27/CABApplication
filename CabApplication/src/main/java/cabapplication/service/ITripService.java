package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.TripBooking;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.ITripRepository;

@Service
public class ITripService {
	@Autowired
	ITripRepository triprepo;

	public List<TripBooking> viewAllTrips() throws TripNotFoundException {

		List<TripBooking> trips = triprepo.findAll();
		if (trips.isEmpty()) {
			throw new TripNotFoundException("Trip not found");
		} else {
			return trips;
		}
	}

	public TripBooking viewTripBooking(int tripBookingId) throws TripNotFoundException {
		TripBooking trip = triprepo.findById(tripBookingId).orElseThrow();
		if (trip == null) {
			throw new TripNotFoundException("Trip not found");
		} else {
			return trip;
		}
	}

	public TripBooking insertTripBooking(TripBooking tripBooking) throws TripNotFoundException {
		TripBooking trip = triprepo.save(tripBooking);
		if (trip == null) {
			throw new TripNotFoundException("Trip not found");
		} else {
			return trip;
		}
	}

	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripNotFoundException {

		if (tripBooking == null) {
			throw new TripNotFoundException("Trip not found");
		} else {
			int id = tripBooking.getTripBookingId();
			TripBooking tripBookingupdated = triprepo.findById(id).orElseThrow();

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
	}

	public String deleteTripBooking(int tripBookingId) throws TripNotFoundException {
		if (triprepo.findById(tripBookingId).orElseThrow() == null) {
			throw new TripNotFoundException("Trip not found");

		}
		triprepo.deleteById(tripBookingId);
		return "Deleted";
	}

	public List<TripBooking> viewAllTrips(int customerId) throws CustomerNotFoundException {
		List<TripBooking> trips = triprepo.getByCustomerId(customerId);
		if (trips == null) {
			throw new CustomerNotFoundException("Customer id not found");

		} else {

			return trips;
		}
	}

	public float calculateBill(int customerId) throws CustomerNotFoundException {
		TripBooking trip = triprepo.findByCustomerId(customerId);
		if (trip == null) {
			throw new CustomerNotFoundException("Customer id not found");

		} else {
			int km = 30;
			float bill = 0.0f;

			if (trip.getDistanceInKm() > 2) {
				bill = (trip.getDistanceInKm() * 30);
			} else {
				bill = 30.0f;
			}
			trip.setBill(bill);
			triprepo.save(trip);
			return trip.getBill();
		}
	}
}
