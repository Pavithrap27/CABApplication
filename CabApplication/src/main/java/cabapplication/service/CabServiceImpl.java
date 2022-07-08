package cabapplication.service;

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
public class CabServiceImpl implements ICabService
{

	@Autowired
	ICabRepository cabrepo;

	@Override
	public List<CabDTO> getAll() throws CabNotFoundException {
		if (cabrepo.findAll()!= null) 
		{
			return Converter.convertCabToDTO(cabrepo.findAll());
		}
		throw new CabNotFoundException("cab not found");
	}


     	@Override
		public CabDTO save(CabDTO cabDto) throws Throwable
		{
			if(cabDto.getCarType()!=null)
			{
			Converter.convertCabToDTO(cabrepo.save(Converter.convertCabDtoToEntity(cabDto)));
			return cabDto;
			}
			throw new CabNotFoundException("Cab not available");
		}
		
		@Override
		public CabDTO update(CabDTO cabDto) throws Throwable
		{
			Cab cab=Converter.convertCabDtoToEntity(cabDto);
			int id = cab.getCabId();
			Supplier s1=()->new CabNotFoundException("no Cab found");
               Cab cabupdated=cabrepo.findById(id).orElseThrow(s1);
               cabupdated.setCabId(cab.getCabId());
               cabupdated.setCarType(cab.getCarType());
               cabupdated.setPerKmRate(cab.getPerKmRate());
               cabrepo.save(cabupdated);
               return Converter.convertCabToDTO(cabupdated);}
		
		@Override
		public String delete(int cabId) throws Throwable
		{
			Supplier s1=()->new CabNotFoundException("Cab not found");
		    cabrepo.findById(cabId).orElseThrow(s1);
			cabrepo.deleteById(cabId);
			return "Deleted";
		}

		@Override
		public List<CabDTO> viewCabsOfType(String carType) throws CabNotFoundException {
			
              if((cabrepo.viewCabsOfType(carType)).isEmpty()) {
	            throw new CabNotFoundException("no cab found");    
	        }
	       
	            return Converter.convertCabToDTO(cabrepo.viewCabsOfType(carType));
		}

	@Override
	public int countCabsOfType(String carType) throws CabNotFoundException {

		if(cabrepo.countCabsOfType(carType)==0)
		{
			throw new CabNotFoundException("No carType found");
			}
		else {
			return cabrepo.countCabsOfType(carType);
		}
	}

}
	