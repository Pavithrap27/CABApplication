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
import cabapplication.service.ICustomerServiceImpl;
import cabapplication.exception.CustomerNotFoundException;

@RestController
@RequestMapping("customer")
public class ICustomerController {

	@Autowired
	ICustomerServiceImpl customerservice;

	@PostMapping(path = "/save")
	public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer) throws Throwable
	{
		return new ResponseEntity<>(customerservice.save(customer), HttpStatus.OK);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customerDto) throws Throwable {
		return new ResponseEntity<>(customerservice.update(customerDto), HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteById")

	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId)throws Throwable {
		return new ResponseEntity<>(customerservice.delete(customerId), HttpStatus.OK);
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<CustomerDTO>> getAll()throws CustomerNotFoundException 
	{
		return new ResponseEntity<>(customerservice.getAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/getById/{customerId}")
	public ResponseEntity<CustomerDTO> getById(@PathVariable int customerId)throws CustomerNotFoundException 
	{
		return new ResponseEntity<>(customerservice.getById(customerId), HttpStatus.OK);

	}

	@GetMapping(path = "/validate/{username}/{password}")
	public ResponseEntity<CustomerDTO> validate(@PathVariable String username, @PathVariable String password)throws CustomerNotFoundException {
		return new ResponseEntity<>(customerservice.validate(username, password), HttpStatus.OK);
	}
}
