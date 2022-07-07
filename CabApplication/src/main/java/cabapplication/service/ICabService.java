package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.dto.CabDTO;
import cabapplication.exception.CabNotFoundException;

@Service
public interface ICabService {
	
	public List<CabDTO> getAll() throws CabNotFoundException;
	public CabDTO save(CabDTO cabDto) throws CabNotFoundException, Throwable;
	public CabDTO update(CabDTO cab) throws CabNotFoundException, Throwable;
	public String delete(int cabId) throws CabNotFoundException, Throwable;
	public List<CabDTO> viewCabsOfType(String carType) throws CabNotFoundException;
	public int countCabsOfType(String carType) throws CabNotFoundException;
}