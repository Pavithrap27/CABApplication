package cabapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cabapplication.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService login;
	
	@GetMapping("getCredentials/{role}/{username}/{password}")
	public String getCredentials(@PathVariable String role, @PathVariable String username, @PathVariable String password)throws Exception 
	{
		return login.getCredentials(role, username, password);
	}
}
