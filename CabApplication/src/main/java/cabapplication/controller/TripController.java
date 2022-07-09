package cabapplication.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import cabapplication.service.TripServiceImpl;

@RestController
@RequestMapping("tripbooking")
public class TripController {
	Log logger = LogFactory.getLog(TripController.class);
	@Autowired
	TripServiceImpl tripservice;
    
	/* Retrieve all the elements */
	@GetMapping("getAll")
	public ResponseEntity<List<TripBookingDTO>> getAll() throws TripNotFoundException {
		logger.info("Getting elements from getall");
		List<TripBookingDTO> trips = tripservice.getAll();
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

	/* Retrieve elements according to the id given as input */
	@GetMapping("getById/{tripBookingId}")
	public ResponseEntity<TripBookingDTO> getById(@PathVariable int tripBookingId) throws TripNotFoundException {
		logger.info("Getting elements by id");
		return new ResponseEntity<>(tripservice.getById(tripBookingId), HttpStatus.OK);
	}

	/* Saves all the elements given as an input */
	@PostMapping("save")
	public ResponseEntity<TripBookingDTO> save(@RequestBody TripBookingDTO tripBookingDto)
			throws TripNotFoundException {
		logger.info("Saving elements ");
		return new ResponseEntity<>(tripservice.save(tripBookingDto), HttpStatus.OK);

	}

	/* Updates the elements according to corresponding input */
	@PutMapping("update")
	public ResponseEntity<TripBookingDTO> update(@RequestBody TripBookingDTO tripDto) throws TripNotFoundException {
		logger.info("Updating elements");
		return new ResponseEntity<>(tripservice.update(tripDto), HttpStatus.OK);
	}

	/* Delete the element based on the id given as an input */
	@DeleteMapping("deleteById/{tripBookingId}")
	public ResponseEntity<String> delete(@PathVariable int tripBookingId) throws TripNotFoundException {
		logger.info("Deleting by id");
		tripservice.delete(tripBookingId);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	/* Retrieve elements according to the customer id as an input */
	@GetMapping("getByCustomerId/{customerId}")
	public ResponseEntity<List<TripBookingDTO>> getByCustomerId(@PathVariable int customerId)throws CustomerNotFoundException {
		logger.info("getting elements by customer id");
		List<TripBookingDTO> trips = tripservice.getByCustomerId(customerId);
		return new ResponseEntity<>(trips, HttpStatus.OK);

	}

	/* Calculate the bill according to the distance traveled */
	@GetMapping("calculateBill/{customerId}")
	public ResponseEntity<Double> calculateBill(@PathVariable int customerId) throws CustomerNotFoundException {
		logger.info("Calculating the bill");
		return new ResponseEntity<>(tripservice.calculateBill(customerId), HttpStatus.OK);
	}
}
