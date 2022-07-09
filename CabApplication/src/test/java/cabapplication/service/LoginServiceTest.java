package cabapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cabapplication.entity.Admin;
import cabapplication.entity.Customer;
import cabapplication.entity.Driver;
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
	void testGetCredentials() throws Exception {
		Admin admin = new Admin();
		admin.setUsername("pavithra");
		admin.setPassword("pavi123");
		Mockito.when(adminRepo.getByUsernameAndPassword("pavithra", "pavi123")).thenReturn(admin);
		assertThat(loginService.getCredentials("admin", "pavithra", "pavi123")).isEqualTo("Login");

		Customer customer = new Customer();
		customer.setUsername("poorna");
		customer.setPassword("poorna123");

		Mockito.when(customerRepo.getByUsernameAndPassword("poorna", "poorna123")).thenReturn(customer);
		assertThat(loginService.getCredentials("customer", "poorna", "poorna123")).isEqualTo("Login");

		Driver driver = new Driver();
		driver.setUsername("akash");
		driver.setPassword("akash123");

		Mockito.when(driverRepo.getByUsernameAndPassword("akash", "akash123")).thenReturn(driver);
		assertThat(loginService.getCredentials("driver", "akash", "akash123")).isEqualTo("Login");

	}
}
