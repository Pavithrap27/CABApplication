package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.dto.TripBookingDTO;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;

@Service
public interface ITripService {

	public List<TripBookingDTO> getAll() throws TripNotFoundException;

	public TripBookingDTO getById(int tripBookingId) throws TripNotFoundException;

	public TripBookingDTO update(TripBookingDTO tripBookingDto) throws TripNotFoundException;

	public String delete(int tripBookingId) throws TripNotFoundException ;

	public List<TripBookingDTO> getByCustomerId(int customerId) throws CustomerNotFoundException;

	public double calculateBill(int customerId) throws CustomerNotFoundException;
}
