package cabapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cabapplication.dto.AdminDTO;

@Service
public class LoginService {
	@Autowired
	IAdminService adminService;
	@Autowired
	ICustomerServiceImpl customerService;
	@Autowired
	IDriverServiceImpl driverService;
	
	//public String getCredentials(@PathVariable String role, @PathVariable String username, @PathVariable String password) {
		//if(role.equalsIgnoreCase("admin"))
		//{
			//return "login";
		//}
	//}
	

}
