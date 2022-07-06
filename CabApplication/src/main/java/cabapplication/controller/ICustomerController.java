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

import cabapplication.entity.Customer;
import cabapplication.service.ICustomerServiceImpl;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.service.ICustomerService;

@RestController
@RequestMapping("customer")
public class ICustomerController {

	ICustomerServiceImpl customerservice;

	@GetMapping(path = "/getcustomers")
	public List<Customer> getcustomers() {
		return customerservice.viewCustomers();
	}

	@PostMapping(path = "/insertcustomer")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerservice.insertCustomer(customer), HttpStatus.OK);

	}

	@PutMapping(path = "/updatecustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerservice.updateCustomer(customer), HttpStatus.OK);
	}

	@DeleteMapping(path = "/customerid")

	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
		return new ResponseEntity<>(customerservice.deleteCustomer(customerId), HttpStatus.OK);
	}

	@GetMapping(path = "/viewcustomers")
	public ResponseEntity<List<Customer>> viewCustomers() {
		return new ResponseEntity<>(customerservice.viewCustomers(), HttpStatus.OK);

	}

	@GetMapping(path = "/viewcustomer{customerid}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable int customerId) {
		return new ResponseEntity<>(customerservice.viewCustomer(customerId), HttpStatus.OK);

	}

	@GetMapping(path = "/validatecustomer")
	public ResponseEntity<Customer> validateCustomer(@PathVariable String username, @PathVariable String password) {
		return new ResponseEntity<>(customerservice.validateCustomer(username, password), HttpStatus.OK);

	}

}
