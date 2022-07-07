package cabapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.Cab;
import cabapplication.service.ICabServiceImpl;

@RestController
@RequestMapping("/cab")

public class ICabController {
	@Autowired
	ICabServiceImpl cabservice;

	@GetMapping("/getCabs")
	public List<Cab> getCab() {
		return cabservice.getCab();
	}


	@PostMapping(path="/insertCab")
	public Cab insertCab(@RequestBody Cab cab) {

		return cabservice.insertCab(cab);
	}

	@PutMapping(path = "/updateCab")
	public Cab updateCab(@RequestBody Cab cab) {
		return cabservice.updateCab(cab);
	}

	@DeleteMapping(path = "/deleteCab")
	public String deleteCab(@PathVariable int cabId) {
		cabservice.deleteCab(cabId);
		return "Deleted";
	}

	@GetMapping(path = "/viewCabsOfType/{carType}")
	public List<Cab> viewCabsOfType(@PathVariable String carType) {
		return cabservice.viewCabsOfType(carType);


	}

	@GetMapping(path = "/countOfCabsType/{carType}")
	public int countCabsOfType(@PathVariable String carType) {

		return cabservice.countCabsOfType(carType);

	}

}