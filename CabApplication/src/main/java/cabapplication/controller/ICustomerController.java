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

import cabapplication.dto.CustomerDTO;
import cabapplication.entity.Customer;
import cabapplication.service.ICustomerServiceImpl;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.service.ICustomerService;

@RestController
@RequestMapping("customer")
public class ICustomerController {

	@Autowired
	ICustomerServiceImpl customerservice;

	@PostMapping(path = "/insertcustomer")
	public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerservice.save(customer), HttpStatus.OK);

	}

	@PutMapping(path = "/updatecustomer")
	public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customerDto)throws CustomerNotFoundException {
		return new ResponseEntity<>(customerservice.updateCustomer(customerDto), HttpStatus.OK);
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
