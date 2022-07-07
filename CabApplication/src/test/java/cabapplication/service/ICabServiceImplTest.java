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

import cabapplication.entity.Cab;
import cabapplication.exception.CabNotFoundException;
import cabapplication.repository.ICabRepository;

@SpringBootTest
class ICabServiceImplTest {
	
	private static final String cab2 = null;

	@Autowired
	ICabServiceImpl iCabServiceImpl;
	
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
		
		Mockito.when(cabrepo.findAll()).thenReturn(cabList);	
		assertThat(iCabServiceImpl.getAll()).isEqualTo(cabList);
		
	}
	@Test
	void testsave() {
		Cab cab1=new Cab();
		
		cab1.setCabId(1);
		cab1.setCarType("Honda");
		cab1.setPerKmRate(16);
		
		Mockito.when(cabrepo.save(cab1)).thenReturn(cab1);
		assertThat(iCabServiceImpl.save(cab1)).isEqualTo(cab1);
		}
	
	@Test
	void testupdateCab() {
		Cab cab1=new Cab();
		
		cab1.setCabId(1);
		cab1.setCarType("Honda");
		cab1.setPerKmRate(16);
		Optional<Cab> cab2=Optional.of(cab1);

		Mockito.when(cabrepo.findById(cab1)).thenReturn(cab2);
		
		Mockito.when(cabrepo.save(cab1)).thenReturn(cab1);
		cab1.setCarType("Audi");
		cab1.setPerKmRate(30);
		
		assertThat(iCabServiceImpl.updateCab(cab1)).isEqualTo(cab1);
			
	}

	@Test
	void testDeleteCab() {
		Cab cab1=new Cab();
		cab1.setCabId(1);
		cab1.setCarType("Honda");
		cab1.setPerKmRate(16);
		Optional<Cab> cab2=Optional.of(cab1);
		
		Mockito.when(cabrepo.findById(cab1)).thenReturn(cab2);
		Mockito.when(cabrepo.existsById(cab1.getCabId())).thenReturn(false);
		assertFalse(cabrepo.existsById(cab1.getCabId()));
	}

}