package cabapplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.Cab;
import cabapplication.exception.CabNotFoundException;
import cabapplication.service.ICabServiceImpl;

@RestController
@RequestMapping("/cab")

public class ICabController {

	ICabServiceImpl cabservice;

	@GetMapping("/getcabs")
	public List<Cab> getCab() {
		return cabservice.getCab();
	}


	@PostMapping(path="/insertcab")
	public Cab insertCab(@RequestBody Cab cab) throws CabNotFoundException {

		return cabservice.insertCab(cab);
	}

	@PutMapping(path = "/updatecab")
	public Cab updateCab(@RequestBody Cab cab) throws CabNotFoundException {
		return cabservice.updateCab(cab);
	}

	@DeleteMapping(path = "/deletecab")
	public String deleteCab(@PathVariable int cabId) throws CabNotFoundException {
		cabservice.deleteCab(cabId);
		return "Deleted";
	}

	@GetMapping(path = "/viewcabsoftype/{carType}")
	public List<Cab> viewCabsOfType(@PathVariable String carType) throws CabNotFoundException {
		return cabservice.viewCabsOfType(carType);


	}

	@GetMapping(path = "/countofcabstype/{carType}")
	public int countCabsOfType(@PathVariable String carType) throws CabNotFoundException {

		return cabservice.countCabsOfType(carType);

	}

}