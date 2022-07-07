package cabapplication.service;

import java.util.ArrayList;
import java.util.List;

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

	private static final String cabDtoList = null;

	private static final Cab[] cabs = null;

	private static final String String = null;

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
		public CabDTO save(CabDTO cabDto) throws CabNotFoundException 
		{
			if (cabDto == null) {
				throw new CabNotFoundException(message);
			} else {
				cabrepo.save(Converter.convertCabDtoToEntity(cabDto));
				return cabDto;
				}
			}
		@Override
		public CabDTO update(CabDTO cabDto) throws CabNotFoundException
		{
			if (cabDto == null) {
				throw new CabNotFoundException(message);
			} 
			else 
			{
				Cab cab=Converter.convertCabDtoToEntity(cabDto);
				int id = cab.getCabId();
				Cab cabupdated = cabrepo.findById(id).orElseThrow();
				cabupdated.setCabId(cab.getCabId());
				cabupdated.setCarType(cab.getCarType());
				cabupdated.setPerKmRate(cab.getPerKmRate());
				cabrepo.save(cabupdated);
				return Converter.convertCabToDTO(cabupdated);
			}
		}
		
		@Override
		public String delete(int cabId) throws CabNotFoundException
		{
			CabDTO cab = Converter.convertCabToDTO(cabrepo.findById(cabId).orElseThrow());
			if(cab==null)
			{
				throw new CabNotFoundException(message);
			}
			else {
				cabrepo.deleteById(cabId);
				return "Deleted";
			}
		}

		@Override
		public List<CabDTO> viewCabsOfType(String carType) throws CabNotFoundException {
			List<CabDTO> cabDtoList=new ArrayList<>();
			List<Cab> cabs=cabrepo.viewCabsOfType(String);
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

		@Override
		public int countCabsOfType(java.lang.String carType) throws CabNotFoundException {
			return 0;
		}

}
	