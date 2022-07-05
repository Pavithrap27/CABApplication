package cabapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.Cab;
import cabapplication.service.ICabService;

@RestController
@RequestMapping("/cab")

public class ICabController {
	@Autowired
	ICabService cabservice;
	public Cab insertCab(Cab cab)
	{
		cabservice.insertCab(cab);
		return cab;
	}

	public Cab updateCab(Cab cab)
	{
		Cab cabupdated=cabservice.updateCab(cab);
		return cabupdated;
	}
	
	public String deleteCab(int cabId)
	{
		cabservice.deleteCab(cabId);
		return "Deleted";
    }
	
	public List<Cab> viewCabsOfType(int cabId) 
	{
		 List<Cab> cabs= cabservice.viewCabsOfType(cabId);
		 return cabs;
	}
	public Cab countCabsOfType(int cabId) 
	{
		Cab cabs=cabservice.countCabsOfType(cabId);
		return cabs;
	}	

}