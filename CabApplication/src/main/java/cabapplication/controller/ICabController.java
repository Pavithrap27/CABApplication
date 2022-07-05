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
import cabapplication.service.ICabService;

@RestController
@RequestMapping("/cab")

public class ICabController {
	@Autowired
	ICabService cabservice;
	@GetMapping(path="/getcabs")
	public List<Cab> getCabs()
	{
		return cabservice.getCab();
	}
	@PostMapping(path="insertcab")
	public Cab insertCab(@RequestBody Cab cab)
	{
		return cabservice.insertCab(cab);
	}
	@PutMapping(path="/updatecab")
	public Cab updateCab(@RequestBody Cab cab)
	{
		Cab cabupdated=cabservice.updateCab(cab);
		return cabupdated;
	}
	@DeleteMapping(path="/deletecab")
	public String deleteCab(int cabId)
	{
		cabservice.deleteCab(cabId);
		return "Deleted";
    }
	@GetMapping(path="/viewcabsoftype/{cabId}")
	public List<Cab> viewCabsOfType(@PathVariable int cabId) 
	{
		 List<Cab> cabs= cabservice.viewCabsOfType(cabId);
		 return cabs;
	}
	@GetMapping(path="/countofcabstype/{cabId}")
	public Cab countCabsOfType(@PathVariable int cabId) 
	{
		Cab cabs=cabservice.countCabsOfType(cabId);
		return cabs;
	}	

}