package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.TripBooking;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.ITripRepository;
import cabapplication.utils.Converter;

@Service
public  class ITripServiceImpl implements ITripService {
    @Autowired
	ITripRepository triprepo;
	

	public List<TripBookingDTO> getAll() throws TripNotFoundException {

		List<TripBookingDTO> trips = Converter.convertTripToDto(triprepo.findAll());
		if (trips.isEmpty()) {
			throw new TripNotFoundException("Trip does not exist");
		} else {
			return trips;
		}
	}

	public TripBookingDTO getById(int tripBookingId) throws TripNotFoundException {
		TripBookingDTO trip = Converter.convertTripToDto(triprepo.findById(tripBookingId).orElseThrow());
		if (trip == null) {
			throw new TripNotFoundException("No trip found");
		} else {
			return trip;
		}
	}

	public TripBookingDTO save(TripBookingDTO tripBookingDto) throws TripNotFoundException {
		TripBookingDTO tripDto = Converter
				.convertTripToDto(triprepo.save(Converter.convertTripToEntity(tripBookingDto)));
		if (tripDto != null) {
			return tripDto;
		}
		throw new TripNotFoundException("no Trip found");
	}

	public TripBookingDTO update(TripBookingDTO tripBookingDto) throws TripNotFoundException {

		if (tripBookingDto == null) {
			throw new TripNotFoundException("Trip not found");
		} else {
			TripBooking trip = Converter.convertTripToEntity(tripBookingDto);
			int id = trip.getTripBookingId();
			TripBooking tripBookingupdated = triprepo.findById(id).orElseThrow();
			tripBookingupdated.setDistanceInKm(trip.getDistanceInKm());
			tripBookingupdated.setCustomerId(trip.getCustomerId());
			tripBookingupdated.setBill(trip.getBill());
			tripBookingupdated.setDriver(trip.getDriver());
			tripBookingupdated.setFromDateTime(trip.getFromDateTime());
			tripBookingupdated.setFromLocation(trip.getFromLocation());
			tripBookingupdated.setToLocation(trip.getToLocation());
			tripBookingupdated.setToDateTime(trip.getToDateTime());
			return Converter.convertTripToDto(triprepo.save(tripBookingupdated));

		}
	}

	public String delete(int tripBookingId) throws TripNotFoundException {
		if (triprepo.findById(tripBookingId).orElseThrow() == null) {
			throw new TripNotFoundException("Trip not found");

		}
		triprepo.deleteById(tripBookingId);
		return "Deleted";
	}

	public List<TripBookingDTO> getByCustomerId(int customerId) throws CustomerNotFoundException {
		List<TripBookingDTO> trips = Converter.convertTripToDto(triprepo.getByCustomerId(customerId));
		if (trips == null) {
			throw new CustomerNotFoundException("Customer id not found");

		} else {

			return trips;
		}
	}

	public double calculateBill(int customerId) throws CustomerNotFoundException {
		TripBooking trip = triprepo.findByCustomerId(customerId);
		if (trip == null) {
			throw new CustomerNotFoundException("Customer id not found");

		} else {
			float baseFair = 30;
			double bill;

			if (trip.getDistanceInKm() > 2) {
				bill = (trip.getDistanceInKm() * baseFair);
			} else {
				bill = baseFair;
			}
			trip.setBill(bill);
			triprepo.save(trip);
			return trip.getBill();
		}
	}
}
