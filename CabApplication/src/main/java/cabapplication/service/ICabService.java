package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Cab;
import cabapplication.repository.ICabRepository;

@Service
public class ICabService {

	@Autowired
	ICabRepository cabrepo;
	
	public Cab insertCab(Cab cab)
	{
		 return cabrepo.save(cab);
	}
	
	public Cab updateCab(Cab cab)
	{
		int id=cab.getCabId();
		Cab c=cabrepo.findById(id).orElseThrow();
		cabrepo.save(c);
		return c;
	}
	
	public String deleteCab(int cabId)
	{
	Cab c=cabrepo.findById(cabId).orElseThrow();
	cabrepo.deleteById(cabId);
	return "Deleted";
	}
	
	public List<Cab> viewCabsOfType(int cabId) 
	{
    List<Cab> lc=cabrepo.findAll();
    return lc;	
	}

	public Cab countCabsOfType(int cabId) {

		return null;
	}	
}