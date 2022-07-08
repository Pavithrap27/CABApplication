package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.dto.CabDTO;
import cabapplication.entity.Cab;
import cabapplication.exception.CabNotFoundException;
import cabapplication.repository.ICabRepository;
import cabapplication.utils.Converter;

@SpringBootTest
class ICabServiceImplTest {

	@Autowired
	ICabServiceImpl iCabService;
	
	@MockBean
	ICabRepository cabrepo;

	@Test
	void testgetAll() throws CabNotFoundException {
		Cab cab1=new Cab();
		cab1.setCabId(1);
		cab1.setCarType("Honda");
		cab1.setPerKmRate(16);
		
		Cab cab2=new Cab();
		cab2.setCabId(2);
		cab2.setCarType("bmw");
		cab2.setPerKmRate(25);
		
		List<Cab> cabList = new ArrayList<>();
		cabList.add(cab1);
		cabList.add(cab2);
		
		CabDTO cabDto=new CabDTO();
		cabDto.setCabId(1);
		cabDto.setCarType("Honda");
		cabDto.setPerKmRate(16);
		
		CabDTO cabDto2=new CabDTO();
		cabDto2.setCabId(2);
		cabDto2.setCarType("bmw");
		cabDto2.setPerKmRate(25);
		
		List<CabDTO> cabListDto = new ArrayList<>();
		cabListDto.add(cabDto);
		cabListDto.add(cabDto2);
		
		
		
		Mockito.when(cabrepo.findAll()).thenReturn(cabList);	
		assertNotNull(iCabService.getAll());
		
	}
	@Test
	void testsave() throws Throwable {
		Cab cab1=new Cab();
		cab1.setCabId(1);
		cab1.setCarType("Honda");
		cab1.setPerKmRate(16);
		CabDTO cabDto=new CabDTO();
		cabDto.setCabId(1);
		cabDto.setCarType("Honda");
		cabDto.setPerKmRate(16);
		

		Mockito.when(cabrepo.save(cab1)).thenReturn(cab1);
		assertThatiCabService.save(cabDto))cab1.isEquals;
		}
	
	@Test
	void testupdate() throws Throwable {
		Cab cab1=new Cab();
		
		cab1.setCabId(1);
		cab1.setCarType("Honda");
		cab1.setPerKmRate(16);
		Optional<Cab> cab2=Optional.of(cab1);

     	Mockito.when(cabrepo.findById(1)).thenReturn(cab2);
		
		Mockito.when(cabrepo.save(cab1)).thenReturn(cab1);
		cab1.setCarType("Audi");
		cab1.setPerKmRate(30);
		
		assertThat(iCabService.update(Converter.convertCabToDTO(cab1))).isEqualTo(cab1);
			
	}
	@Test
	void testDelete() {
		 Cab cab1=new Cab();
		cab1.setCabId(1);
		cab1.setCarType("Honda");
		cab1.setPerKmRate(16);
		Optional<Cab> cab2=Optional.of(cab1);
		
		Mockito.when(cabrepo.findById(1)).thenReturn(cab2);
		
		Mockito.when(cabrepo.existsById(cab1.getCabId())).thenReturn(false);
		assertFalse(cabrepo.existsById(cab1.getCabId()));
	}
}




