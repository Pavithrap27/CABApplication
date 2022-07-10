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
import cabapplication.dto.CustomerDTO;
import cabapplication.service.CustomerServiceImpl;
import cabapplication.exception.CustomerNotFoundException;

@RestController
@RequestMapping("customer")
public class CustomerController {

	Log logger = LogFactory.getLog(CustomerController.class);
	
	@Autowired
	CustomerServiceImpl customerservice;

	/* Saves all the elements given as an input */
	@PostMapping(path = "/save")
	public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer) throws Throwable {
		logger.info("saving the elements");
		return new ResponseEntity<>(customerservice.save(customer), HttpStatus.OK);
	}

	/* Updates the elements according to corresponding input */
	@PutMapping(path = "/update")
	public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customerDto) throws Throwable {
		logger.info("updating elements");
		return new ResponseEntity<>(customerservice.update(customerDto), HttpStatus.OK);
	}

	/* Delete the element based on the id given as an input */
	@DeleteMapping(path = "/delete/{customerId}")
	public ResponseEntity<String> delete(@PathVariable int customerId) throws Throwable {
		logger.info("Deleting elements ");
		return new ResponseEntity<>(customerservice.delete(customerId), HttpStatus.OK);
	}

	/* Retrieve all the elements */
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<CustomerDTO>> getAll() throws CustomerNotFoundException {
		logger.info("getting elements from getAll");
		return new ResponseEntity<>(customerservice.getAll(), HttpStatus.OK);
	}

	/* Retrieve the element based on the Id given as input */
	@GetMapping(path = "/getById/{customerId}")
	public ResponseEntity<CustomerDTO> getById(@PathVariable int customerId) throws Throwable {
		logger.info("getting the element based on the Id");
		return new ResponseEntity<>(customerservice.getById(customerId), HttpStatus.OK);

	}

	/* Validate the customer based on the given input */
	@GetMapping(path = "/validate/{username}/{password}")
	public ResponseEntity<CustomerDTO> validate(@PathVariable String username, @PathVariable String password)
			throws Throwable {
		logger.info("validating the customer based on the username and password");
		return new ResponseEntity<>(customerservice.validate(username, password), HttpStatus.OK);
	}
}
