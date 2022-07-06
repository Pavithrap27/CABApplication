package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import cabapplication.dto.AdminDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CabNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;

public interface IAdminService {

<<<<<<< HEAD
	@Autowired
	IAdminRepository adminrepo;
	ITripService tripservice;
	
	String message = "Admin not found";
=======
	public List<AdminDTO> getAll() throws AdminNotFoundException;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

<<<<<<< HEAD
	public List<Admin> getAdmin() throws AdminNotFoundException {
		List<Admin> admin = adminrepo.findAll();
		if (admin.isEmpty()) {
			throw new AdminNotFoundException(message);
		} else {
			return admin;
		}
	}
=======
	public AdminDTO save(Admin admin) throws AdminNotFoundException;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

<<<<<<< HEAD
	public Admin insertAdmin(Admin admin) throws AdminNotFoundException {
		if (admin == null) {
			throw new AdminNotFoundException(message);
		} else {
			adminrepo.save(admin);
			return admin;
		}
=======
	public AdminDTO update(Admin admin) throws AdminNotFoundException;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

	public String delete(Admin admin) throws AdminNotFoundException;

<<<<<<< HEAD
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		if (admin == null) {
			throw new AdminNotFoundException(message);
		} else {
			int index = admin.getAdminId();
			Admin adminupdated = adminrepo.findById(index).orElseThrow();
			adminupdated.setEmail(admin.getEmail());
			adminupdated.setMobileNumber(admin.getMobileNumber());
			adminupdated.setPassword(admin.getPassword());
			adminupdated.setUsername(admin.getUsername());
			adminupdated.setAddress(admin.getAddress());
			adminrepo.save(adminupdated);
			return adminupdated;
		}
	}
=======
	public AdminDTO getById(int adminId) throws AdminNotFoundException;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

<<<<<<< HEAD
	public String deleteAdmin(Admin admin) throws AdminNotFoundException {
		if (admin == null) {
			throw new AdminNotFoundException(message);
		} else {
			adminrepo.delete(admin);
			return "Deleted";
		}
=======
	public List<TripBookingDTO> getByCustomerId(int customerId) throws CustomerNotFoundException;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

	public List<TripBookingDTO> getTripsCabwise() throws CabNotFoundException;

	public List<TripBookingDTO> getTripsDatewise() throws TripNotFoundException;

<<<<<<< HEAD
		Admin admin = adminrepo.findById(adminId).orElseThrow();
		if (admin == null) {
			throw new AdminNotFoundException(message);
		} else {
			return admin;
		}
	}
=======
	public List<TripBookingDTO> getTripsCustomerwise() throws CustomerNotFoundException;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

	public List<TripBooking> getAllTripsForDays() throws TripNotFoundException;

	public List<TripBookingDTO> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime ToDate)
			throws CustomerNotFoundException;
}
