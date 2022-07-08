package cabapplication.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cabapplication.repository.IAdminRepository;

class IAdminServiceImplTest {
	
	@Autowired
	IAdminServiceImpl adminservice;
	@Autowired
	IAdminRepository adminrepo;
	
	@BeforeEach
	

	@Test
	void testGetAll() {
		
		
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetByCustomerId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTripsCabwise() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTripsDatewise() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTripsCustomerwise() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllTripsForDays() {
		fail("Not yet implemented");
	}

}
