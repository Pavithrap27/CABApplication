package cabapplication.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cabapplication.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	Log logger = LogFactory.getLog(LoginController.class);
	
	@Autowired
	LoginService login;
	/*Retrieve the element according to the given input*/
	@GetMapping("getCredentials/{role}/{username}/{password}")
	public String getCredentials(@PathVariable String role, @PathVariable String username, @PathVariable String password)throws Exception 
	{
		logger.info("getting the element");
		return login.getCredentials(role, username, password);
	}
}
