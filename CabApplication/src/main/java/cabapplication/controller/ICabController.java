package cabapplication.controller;

import java.util.List;

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

import cabapplication.dto.CabDTO;
import cabapplication.exception.CabNotFoundException;
import cabapplication.service.ICabServiceImpl;

@RestController
@RequestMapping("/cab")

public class ICabController {

	private static final String carType = null;
	ICabServiceImpl cabservice;

	@GetMapping("/getAll")
	public ResponseEntity<List<CabDTO>> getAll() throws CabNotFoundException
	{
		List<CabDTO> cab=cabservice.getAll();
      	return new ResponseEntity<>(cab,HttpStatus.OK);
    }
	
	@PostMapping(path = "/save")
	public ResponseEntity<CabDTO> save(@RequestBody CabDTO cab) throws CabNotFoundException 
	{
		return new ResponseEntity<>(cabservice.save(cab),HttpStatus.OK);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<CabDTO> update(@RequestBody CabDTO cab) throws CabNotFoundException 
	{
		return new ResponseEntity<>(cabservice.update(cab),HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/deleteById/{cabId}")
	public ResponseEntity<String> delete(@PathVariable int cabId) throws CabNotFoundException  
	{
		return new ResponseEntity<>(cabservice.delete(cabId),HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/viewcabsoftype/{carType}\"")
	public ResponseEntity<List<CabDTO>> viewcabsoftype() throws CabNotFoundException 
	{
		return new ResponseEntity<>( cabservice.viewCabsOfType(carType),HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/countofcabstype/{carType}")
	public ResponseEntity<CabDTO> getById(@PathVariable int cabid) throws CabNotFoundException 
	{
		return new ResponseEntity<>(cabservice.countCabsOfType(carType),HttpStatus.OK);
	}

}