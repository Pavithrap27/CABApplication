package cabapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.repository.IAdminRepository;

@Service
public class IAdminService {
	
	@Autowired
	IAdminRepository adminrepo;
	
	
	

}
