package cabapplication.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.dto.CabDTO;
import cabapplication.exception.CabNotFoundException;
import cabapplication.service.CabServiceImpl;

@RestController
@RequestMapping("/cab")
@CrossOrigin
public class CabController {

	Log logger = LogFactory.getLog(CabController.class);

	@Autowired
	CabServiceImpl cabservice;

	/* Retrieve all the elements */
	@GetMapping("/getAll")
	public ResponseEntity<List<CabDTO>> getAll() throws CabNotFoundException {
		logger.info("getting elements from getAll");
		return new ResponseEntity<>(cabservice.getAll(), HttpStatus.OK);
	}

	/* Saves all the elements given as an input */
	@PostMapping(path = "/save")
	public ResponseEntity<CabDTO> save(@RequestBody CabDTO cab) throws Throwable {
		logger.info("saving the elements");
		return new ResponseEntity<>(cabservice.save(cab), HttpStatus.OK);
	}

	/* Updates the elements according to corresponding input */
	@PutMapping(path = "/update")
	public ResponseEntity<CabDTO> update(@RequestBody CabDTO cab) throws Throwable {
		logger.info("updating elements");
		return new ResponseEntity<>(cabservice.update(cab), HttpStatus.OK);
	}

	/* Delete the element based on the id given as an input */
	@DeleteMapping(path = "/deleteById/{cabId}")
	public ResponseEntity<String> delete(@PathVariable int cabId) throws Throwable {
		logger.info("Deleting elements ");
		return new ResponseEntity<>(cabservice.delete(cabId), HttpStatus.OK);
	}

	/* Retrieves the elements based on the type given as input */
	@GetMapping(path = "/viewCabsOfType/{carType}")
	public ResponseEntity<List<CabDTO>> viewCabsOfType(@PathVariable String carType) throws CabNotFoundException {
		logger.info("getting all the elements based on carType ");
		return new ResponseEntity<>(cabservice.viewCabsOfType(carType), HttpStatus.OK);
	}

	/* Retrieves the count of the elements based on the type */
	@GetMapping(path = "/countCabsOfType/{carType}")
	public ResponseEntity<Integer> countCabsOfType(@PathVariable String carType) throws CabNotFoundException {
		logger.info("getting count of all the elements based on carType");
		return new ResponseEntity<>(cabservice.countCabsOfType(carType), HttpStatus.OK);
	}
}
