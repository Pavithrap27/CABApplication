package cabapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.DriverNotFoundException;
import cabapplication.repository.IAdminRepository;
import cabapplication.repository.ICustomerRepository;
import cabapplication.repository.IDriverRepository;

@Service
public class LoginService {
	@Autowired
	IAdminRepository adminRepo;
	@Autowired
	ICustomerRepository customerRepo;
	@Autowired
	IDriverRepository driverRepo;
	private String msg="Login";

	public String getCredentials(String role, String username, String password) throws Exception {
		if (role.equalsIgnoreCase("admin")) {
			if (adminRepo.getByUsernameAndPassword(username, password) != null) {
				return msg;
			}
			throw new AdminNotFoundException("Admin not found");
		} else if (role.equalsIgnoreCase("Driver")) {
			if (driverRepo.getByUsernameAndPassword(username, password) != null) {
				return msg;

			}
			throw new DriverNotFoundException("Driver Not Found");

		} else if (role.equalsIgnoreCase("customer")) {
			if (customerRepo.getByUsernameAndPassword(username, password) != null) {
				return msg;
			}
			throw new CustomerNotFoundException("Customer Not Found");
		}

		return "invalid session";

	}
}
