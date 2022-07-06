package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Cab;
import cabapplication.exception.CabNotFoundException;
import cabapplication.repository.ICabRepository;

@Service
public abstract class ICabServiceImpl implements ICabService
{

	@Autowired

	ICabRepository cabrepo;
	String message="Cab not found";
	private Object cabs;

	public List<Cab> getCabs()throws CabNotFoundException {
		 List<Cab> cab = cabrepo.findAll();
		 if (cab.isEmpty()) {
				throw new CabNotFoundException(message);
		} else {
			return cab;
		}
	}

	public Cab insertCab(Cab cab) throws CabNotFoundException {
		if (cab == null) {
			throw new CabNotFoundException(message);
		} else {
			cabrepo.save(cab);
			return cab;
			}
}

	public Cab updateCab(Cab cab) throws CabNotFoundException {
		if (cab == null) {
			throw new CabNotFoundException(message);
		} 
		else 
		{
		
		int id = cab.getCabId();
		Cab c = cabrepo.findById(id).orElseThrow();
		c.setCabId(cab.getCabId());
		c.setCarType(cab.getCarType());
		c.setPerKmRate(cab.getPerKmRate());
		cabrepo.save(c);
		return c;
	}
	}

	public String deleteCab(int cabId) throws CabNotFoundException {
		Cab cab = cabrepo.findById(cabId).orElseThrow();
		if (cab == null)
		{
			throw new CabNotFoundException(message);
		}
     	else
     	{
		cabrepo.deleteById(cabId); 
		return "Deleted";
	}
	}
	
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException {
		List<Cab> lc = cabrepo.viewCabsOfType(carType);
		if(lc.isEmpty()) 
			{
				throw new CabNotFoundException(message);
			}
			else 
			{	
		return lc;
	}
	}

	public int countCabsOfType(String carType) throws CabNotFoundException {
	int cab =cabrepo.countCabsOfType(carType);
		if(cabs==null)
		{
			throw new CabNotFoundException(message);
		}
		else 
		{
			return cab;
		}
	}
}		