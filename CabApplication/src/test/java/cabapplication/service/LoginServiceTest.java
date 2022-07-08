package cabapplication.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.entity.Admin;
import cabapplication.repository.IAdminRepository;
import cabapplication.repository.ICustomerRepository;
import cabapplication.repository.IDriverRepository;

@SpringBootTest
class LoginServiceTest {
	@Autowired
	LoginService loginService;
	@MockBean
	IAdminRepository adminRepo;
	@MockBean
	ICustomerRepository customerRepo;
    @MockBean
    IDriverRepository driverRepo;
	

	@Test
	void testGetCredentials() throws Exception{
		Admin admin= new Admin();
		admin.setUsername("pavithra");
		admin.setPassword("pavi123");
		
		Mockito.when(loginService.getCredentials("admin","pavithra", "pavi123")).thenReturn("login");
		
	}

}
