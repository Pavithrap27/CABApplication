package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
class CabServiceImplTest {

	@Autowired
	CabServiceImpl cabservice;

	
	@MockBean
	ICabRepository cabrepo;
	
	CabDTO cab1=null;
	CabDTO cab2=null;
	@BeforeEach
	public void testBeforeEach() {
		cab1=new CabDTO();
		cab2=new CabDTO();
		
		cab1.setCabId(1);
		cab1.setCarType("Honda");
		cab1.setPerKmRate(11.5f);
		
		cab2.setCabId(2);
		cab2.setCarType("bmw");
		cab2.setPerKmRate(25.5f);
	}

	@Test
	void testgetAll() throws Throwable 
	{
		
		List<Cab> cabList = new ArrayList<>();
		cabList.add(Converter.convertCabDtoToEntity(cab1));
		cabList.add(Converter.convertCabDtoToEntity(cab2));
		
		Mockito.when(cabrepo.findAll()).thenReturn(cabList);	
		assertNotNull(cabservice.getAll());		
	}
	@Test
	void testsave() throws Throwable
	{
		
		Cab c=Converter.convertCabDtoToEntity(cab1);
		Mockito.when(cabrepo.save(c)).thenReturn(c);
		assertThat(cabservice.save(cab1)).isEqualTo(cab1);
	}
	
	@Test
	void testupdate() throws Throwable 
	{
		Cab c=Converter.convertCabDtoToEntity(cab1);
		Optional<Cab> cab2=Optional.of(c);
		Cab c1=Converter.convertCabDtoToEntity(cab1);
		Mockito.when(cabrepo.findById(1)).thenReturn(cab2);
		Mockito.when(cabrepo.save(c1)).thenReturn(c1);
		equals(cabservice.update(cab1));
	}
	@Test
	void testDelete() 
	{
		Cab c=Converter.convertCabDtoToEntity(cab1);
		Optional<Cab> cab2=Optional.of(c);
		
		Mockito.when(cabrepo.findById(1)).thenReturn(cab2);
		Mockito.when(cabrepo.existsById(cab1.getCabId())).thenReturn(false);
		assertFalse(cabrepo.existsById(cab1.getCabId()));
	}
	
	@Test
	void testviewCabsOfType() throws CabNotFoundException
	{
		
		List<Cab> cabList=new ArrayList<>();
		cabList.add(Converter.convertCabDtoToEntity(cab1));
		cabList.add(Converter.convertCabDtoToEntity(cab2));
		Mockito.when(cabrepo.viewCabsOfType(null)).thenReturn(cabList);
		assertNotNull(cabservice.viewCabsOfType(null));
	}
	
	@Test
	void countCabsOfType() {
		
		Cab c=Converter.convertCabDtoToEntity(cab1);
		Optional<Cab> cab2=Optional.of(c);
		Mockito.when(cabrepo.findById(1)).thenReturn(cab2);
		assertThat(cabrepo.existsById(cab1.getCabId()));
		
	}
}