package cabapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import cabapplication.entity.Cab;
import cabapplication.repository.ICabRepository;

@Service
public class ICabService {

	@Autowired
	ICabRepository cabrepo;

	public List<Cab> getCab() {
		return cabrepo.findAll();

	}

	public Cab insertCab(Cab cab) {
		return cabrepo.save(cab);
	}

	public Cab updateCab(Cab cab) {
		int id = cab.getCabId();
		Cab c = cabrepo.findById(id).orElseThrow();
		c.setCabId(cab.getCabId());
		c.setCarType(cab.getCarType());
		c.setPerKmRate(cab.getPerKmRate());
		cabrepo.save(c);
		return c;
	}

	public String deleteCab(int cabId) {
		Cab c = cabrepo.findById(cabId).orElseThrow();
		cabrepo.deleteById(cabId);
		return "Deleted";
	}

	public List<Cab> viewCabsOfType(String carType) {
		 return cabrepo.viewCabsOfType(carType);
	}

	public int countCabsOfType(String carType) {
		return cabrepo.countCabsOfType(carType);

	}
}