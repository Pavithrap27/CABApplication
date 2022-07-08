package cabapplication.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.dto.AdminDTO;
import cabapplication.entity.Admin;
import cabapplication.entity.Cab;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.repository.IAdminRepository;
import cabapplication.utils.Converter;

@SpringBootTest
class IAdminServiceImplTest {
	@Autowired
	IAdminService adminService;
	@MockBean
	Converter convert;
	@MockBean
	IAdminRepository adminRepo;
	

	@Test
	void testGetAll() throws AdminNotFoundException  {
		Admin admin=new Admin();
		admin.setAdminId(1);
		admin.setUsername("pavithra");
		admin.setPassword("pavi123");
		admin.setMobileNumber("8976522291");
		admin.setEmail("pavi@gmail.com");
		admin.setAddress("no 13,bangalore");
		
		Admin admin1=new Admin();
		admin1.setAdminId(2);
		admin1.setUsername("poorna");
		admin1.setPassword("poorna123");
		admin1.setMobileNumber("8618503125");
		admin1.setEmail("poorna@gmail.com");
		admin1.setAddress("no 18,banagalore");
		List<Admin> list = new ArrayList<>();
		list.add(admin);
		list.add(admin1);
		Mockito.when(adminRepo.findAll()).thenReturn(list);
		assertThat(adminService.getAll()).isEqualTo(Converter.convertToDTO(list));
	}

	@Test
	void testGetById() throws Throwable {
		Admin admin=new Admin();
		admin.setAdminId(1);
		admin.setUsername("pavithra");
		admin.setPassword("pavi123");
		admin.setMobileNumber("8976522291");
		admin.setEmail("pavi@gmail.com");
		admin.setAddress("no 13,bangalore");
		Optional<Admin> optional =Optional.of(admin);
		Mockito.when(adminRepo.findById(1)).thenReturn(optional);
		assertThat(adminService.getById(1)).isEqualTo(Converter.convertToDTO(admin));
	}

	@Test
	void testGetByCustomerId() {
		
	}

	@Test
	void testGetTripsCabwise() {
		
	}

	@Test
	void testSave() {
		
	}

	@Test
	void testUpdate() {
		
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

	@Test
	void testGetTripsDatewise() {
		
	}

	@Test
	void testGetTripsCustomerwise() {
		
	}

	@Test
	void testGetAllTripsForDays() {
		
	}

}
