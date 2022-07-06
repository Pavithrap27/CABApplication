package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.entity.Cab;
@Service
public interface ICabService {
	
	public List<Cab> getCab();
	public Cab updateCab(Cab cab);
	public String deleteCab(int cabId);
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);
	
}
