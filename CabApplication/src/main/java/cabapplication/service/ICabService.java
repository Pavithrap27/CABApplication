package cabapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;
import cabapplication.dto.CabDTO;
import cabapplication.exception.CabNotFoundException;

@Service
public interface ICabService {
	
	public List<CabDTO> getAll() throws CabNotFoundException;
	public CabDTO save(CabDTO cabDto) throws  Throwable;
	public CabDTO update(CabDTO cab) throws  Throwable;
	public String delete(int cabId) throws  Throwable;
	public List<CabDTO> viewCabsOfType(String carType) throws CabNotFoundException;
	public int countCabsOfType(String carType) throws CabNotFoundException;
}