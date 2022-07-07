package cabapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cabapplication.dto.CabDTO;
import cabapplication.entity.Cab;
import cabapplication.exception.CabNotFoundException;
import cabapplication.repository.ICabRepository;
import cabapplication.utils.Converter;

@Service
@Transactional
public class ICabServiceImpl implements ICabService
{

	@Override
	public List<CabDTO> getAll() throws CabNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CabDTO save(CabDTO cabDto) throws CabNotFoundException, Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CabDTO update(CabDTO cab) throws CabNotFoundException, Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int cabId) throws CabNotFoundException, Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CabDTO> viewCabsOfType(String carType) throws CabNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCabsOfType(String carType) throws CabNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}
}