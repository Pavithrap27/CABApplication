package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.entity.Cab;
import cabapplication.exception.CabNotFoundException;

@Service
public interface ICabService {
	
	public List<Cab> getCab();
	public Cab updateCab(Cab cab) throws CabNotFoundException;
	public String deleteCab(int cabId) throws CabNotFoundException;
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
	public int countCabsOfType(String carType) throws CabNotFoundException;
	
}

