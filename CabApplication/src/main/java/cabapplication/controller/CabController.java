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

import cabapplication.dto.CabDTO;
import cabapplication.exception.CabNotFoundException;
import cabapplication.service.CabServiceImpl;

@RestController
@RequestMapping("/cab")

public class CabController {

	@Autowired
	CabServiceImpl cabservice;

	@GetMapping("/getAll")
	public ResponseEntity<List<CabDTO>> getAll() throws CabNotFoundException {

		return new ResponseEntity<>(cabservice.getAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/save")
	public ResponseEntity<CabDTO> save(@RequestBody CabDTO cab) throws Throwable {
		return new ResponseEntity<>(cabservice.save(cab), HttpStatus.OK);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<CabDTO> update(@RequestBody CabDTO cab) throws Throwable {
		return new ResponseEntity<>(cabservice.update(cab), HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteById/{cabId}")
	public ResponseEntity<String> delete(@PathVariable int cabId) throws Throwable {
		return new ResponseEntity<>(cabservice.delete(cabId), HttpStatus.OK);
	}

	@GetMapping(path = "/viewCabsOfType/{carType}")
	public ResponseEntity<List<CabDTO>> viewCabsOfType(@PathVariable String carType) throws CabNotFoundException {
		return new ResponseEntity<>(cabservice.viewCabsOfType(carType), HttpStatus.OK);
	}

	@GetMapping(path = "/countCabsOfType/{carType}")
	public ResponseEntity<Integer> countCabsOfType(@PathVariable String carType) throws CabNotFoundException {
		return new ResponseEntity<>(cabservice.countCabsOfType(carType), HttpStatus.OK);
	}
}

