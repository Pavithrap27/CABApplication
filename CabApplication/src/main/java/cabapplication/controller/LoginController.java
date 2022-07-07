package cabapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.dto.AdminDTO;
import cabapplication.service.IAdminServiceImpl;
import cabapplication.service.ICustomerServiceImpl;
import cabapplication.service.IDriverServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	IAdminServiceImpl adminService;
	@Autowired
	ICustomerServiceImpl customerService;
	@Autowired
	IDriverServiceImpl driverService;
	
	//@GetMapping("getCredentials/role/username/password")
	/*public String getCredentials(@PathVariable String role, @PathVariable String username, @PathVariable String password) {
		if(role.equalsIgnoreCase("admin"))
		{
			AdminDTO admin = 
		}
	}*/
	
	
}
