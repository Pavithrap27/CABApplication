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

import cabapplication.dto.TripBookingDTO;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.service.ITripServiceImpl;

@RestController
@RequestMapping("tripbooking")
public class ITripController {
	
	ITripServiceImpl tripservice;

	@GetMapping("viewAllTrips")
	public ResponseEntity<List<TripBookingDTO>> getAll() throws TripNotFoundException{
		List<TripBookingDTO> trips = tripservice.getAll();
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

	@GetMapping("viewAllBookings/{tripBookingId}")
	public ResponseEntity<TripBookingDTO> getById(@PathVariable int tripBookingId) throws TripNotFoundException {
		return new ResponseEntity<>(tripservice.getById(tripBookingId), HttpStatus.OK);
	}

	@PostMapping("insertTripBooking")
	public ResponseEntity<TripBookingDTO> save(@RequestBody TripBookingDTO tripBookingDto) throws TripNotFoundException {
		return new ResponseEntity<>(tripservice.save(tripBookingDto), HttpStatus.OK);
		
	}

	@PutMapping("updateTripBooking")
	public ResponseEntity<TripBookingDTO> update(@RequestBody TripBookingDTO tripDto) throws TripNotFoundException {
		 return new ResponseEntity<>(tripservice.update(tripDto), HttpStatus.OK);
	}

	@DeleteMapping("deleteTripBooking/{tripBookingId}")
	public ResponseEntity<String> delete(@PathVariable int tripBookingId) throws TripNotFoundException {
		tripservice.delete(tripBookingId);
		return  new ResponseEntity<>("Deleted", HttpStatus.OK);
		
	}

	@GetMapping("viewAllTrips/{customerId}")
	public ResponseEntity<List<TripBookingDTO>> getByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException {
		List<TripBookingDTO> trips = tripservice.getByCustomerId(customerId);
       return new ResponseEntity<>(trips, HttpStatus.OK);
		

	}

	@GetMapping("calculateBill/{customerId}")
	public ResponseEntity<Double> calculateBill(int customerId) throws CustomerNotFoundException
	{
		return new ResponseEntity<>(tripservice.calculateBill(customerId), HttpStatus.OK);
	}
}
