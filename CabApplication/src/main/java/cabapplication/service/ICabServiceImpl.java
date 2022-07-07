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
	@Autowired
	ICabRepository cabrepo;
	
	String message="Cab not found";
	@Override
	public List<CabDTO> getAll() throws CabNotFoundException {
		List<CabDTO> cabDtoList=new ArrayList<>();
		Iterable<Cab> cabs = cabrepo.findAll();
		if (cabs== null) {
			throw new CabNotFoundException(message);
		} 
		 else {
			 for(Cab cab:cabs) {
					cabDtoList.add(Converter.convertCabToDTO(cab));
				}
				return cabDtoList;
			}
		}

		@Override
		public CabDTO save(CabDTO cabDto) throws Throwable
		{
			Supplier s1=()->new CabNotFoundException("Cab not available");
			int cabId=cabDto.getCabId();
			CabDTO cab=Converter.convertCabToDTO(cabrepo.findById(cabId).orElseThrow(s1));
			
			cabrepo.save(Converter.convertCabDtoToEntity(cabDto));
			return cabDto;
			}
		
		@Override
		public CabDTO update(CabDTO cabDto) throws Throwable
		{
			Cab cab=Converter.convertCabDtoToEntity(cabDto);
			int id = cab.getCabId();
			Supplier s1=()->new CabNotFoundException("Cab not found");

				Cab cabupdated=cabrepo.findById(id).orElseThrow();
				cabupdated.setCabId(cab.getCabId());
				cabupdated.setCarType(cab.getCarType());
				cabupdated.setPerKmRate(cab.getPerKmRate());
				cabrepo.save(cabupdated);
				return Converter.convertCabToDTO(cabupdated);
		}
		
			
		@SuppressWarnings({ "unchecked", "unchecked" })
		@Override
		public String delete(int cabId) throws Throwable
		{
			Supplier s1=()->new CabNotFoundException("Cab not found");
			Converter.convertCabToDTO(cabrepo.findById(cabId).orElseThrow(s1));
			
			cabrepo.deleteById(cabId);
			return "Deleted";
		}

		@Override
		public List<CabDTO> viewCabsOfType(String carType) throws CabNotFoundException {
			List<CabDTO> cabDtoList=new ArrayList<>();
			List<Cab> cabs=cabrepo.viewCabsOfType(carType);
			if(cabs.isEmpty()) {
				throw new CabNotFoundException(message);	
			}
			else {
				for(Cab cab:cabs) {
					cabDtoList.add(Converter.convertCabToDTO(cab));
				}
				return cabDtoList;
			}
		}
}
//		@Override
//		public int countCabsOfType(String carType) throws CabNotFoundException {
//			CabDTO cabDto=Converter.convertCabToDTO(cabrepo.countCabsOfType(carType).orElseThrow());
//			if(cabDto==null)
//			{
//				throw new CabNotFoundException(message);
//			}
//			else {
//				return cabDto;
//			}
//		}
//}
	