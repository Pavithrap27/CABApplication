package cabapplication.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.TripBooking;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.ITripRepository;
import cabapplication.utils.Converter;

@Service
public  class TripServiceImpl implements ITripService {
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
		TripBooking trip =triprepo.findById(tripBookingId).orElseThrow();
		if (trip == null) {
			throw new TripNotFoundException("No trip found");
		} else {
			return Converter.convertTripToDto(trip);
		}
	}

	public TripBookingDTO save(TripBookingDTO tripBookingDto) throws TripNotFoundException 
	{
		if (tripBookingDto.getFromLocation() != null) {
		triprepo.save(Converter.convertTripToEntity(tripBookingDto));
		return tripBookingDto;
		}
		throw new TripNotFoundException("no Trip found");
	}

	public TripBookingDTO update(TripBookingDTO tripBookingDto) throws TripNotFoundException {
			TripBooking trip = Converter.convertTripToEntity(tripBookingDto);
			int id = trip.getTripBookingId();
			Supplier<TripNotFoundException> s1=()->new TripNotFoundException("Trip not found");
			TripBooking tripBookingupdated = triprepo.findById(id).orElseThrow(s1);
			tripBookingupdated.setDistanceInKm(trip.getDistanceInKm());
			tripBookingupdated.setCustomerId(trip.getCustomerId());
			tripBookingupdated.setBill(trip.getBill());
			tripBookingupdated.setFromDateTime(trip.getFromDateTime());
			tripBookingupdated.setFromLocation(trip.getFromLocation());
			tripBookingupdated.setToLocation(trip.getToLocation());
			tripBookingupdated.setToDateTime(trip.getToDateTime());
			return Converter.convertTripToDto(triprepo.save(tripBookingupdated));

		}

	public String delete(int tripBookingId) throws TripNotFoundException  {
		Supplier<TripNotFoundException> s1=()-> new TripNotFoundException("Trip not found");
		triprepo.findById(tripBookingId).orElseThrow(s1);
		triprepo.deleteById(tripBookingId);
		return "Deleted";
	}

	public List<TripBookingDTO> getByCustomerId(int customerId) throws CustomerNotFoundException {
		List<TripBooking> trips =triprepo.getByCustomerId(customerId);
		if (trips.isEmpty()) {
			throw new CustomerNotFoundException("Customer id not found");

		} else {

			return  Converter.convertTripToDto(trips);
		}
	}

	public double calculateBill(int customerId) throws CustomerNotFoundException {
		TripBooking trip =triprepo.findByCustomerId(customerId);
		if (trip == null) {
			throw new CustomerNotFoundException("Customer id not found");

		} 
		else {
			
			double baseFair = 30.0;
			double bill;

			if (trip.getDistanceInKm()> 2) {
				bill = (trip.getDistanceInKm() * baseFair);
			} else {
				bill = baseFair;
			}
			return bill;
		}
	}
}
