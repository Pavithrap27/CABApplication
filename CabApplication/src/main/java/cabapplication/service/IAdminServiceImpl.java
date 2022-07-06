package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.repository.IAdminRepository;

@Service
public abstract  class IAdminServiceImpl implements IAdminService
{

	@Autowired
	IAdminRepository adminrepo;
	@Autowired
	ITripServiceImpl tripservice;
	@Override
	public Admin getAdmin() throws AdminNotFoundException {
		List<Admin> admin = adminrepo.findAll();
		if (admin.isEmpty()) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return (Admin) admin;
		}
	}
	@Override
	public Admin insertAdmin(Admin admin) throws AdminNotFoundException {
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			adminrepo.save(admin);
			return admin;
		}

	}
	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
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
	@Override
	public String deleteAdmin(Admin admin) throws AdminNotFoundException {
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			adminrepo.delete(admin);
			return "Deleted";
		}

	}
	@Override
	public Admin viewAdmin(int adminId) throws AdminNotFoundException {

		Admin admin = adminrepo.findById(adminId).get();
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return admin;
		}
	}
	@Override
	public List<TripBooking> getAllTrips(int customerId) throws AdminNotFoundException {
		List<TripBooking> trips = tripservice.viewAllTrips(customerId);
		if (trips.isEmpty()) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return trips;
		}
	}
	@Override
	public List<TripBooking> getTripsCabwise() throws AdminNotFoundException {
		List<TripBooking> trips = adminrepo.getTripsCabwise();
		if (trips.isEmpty()) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return trips;
		}
	}
	@Override
	public List<TripBooking> getTripsDatewise() throws AdminNotFoundException {
		List<TripBooking> trips = adminrepo.getTripsDatewise();
		if (trips.isEmpty()) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return trips;
		}

	}
	@Override
	public List<TripBooking> getTripsCustomerwise() throws AdminNotFoundException {
		List<TripBooking> trips = adminrepo.getTripCustomerwise();
		if (trips.isEmpty()) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return trips;
		}
	}
	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime ToDate)
			throws AdminNotFoundException {
		List<TripBooking> trips = adminrepo.getAllTripsForDays(customerId, fromDate, ToDate);
		if (trips.isEmpty()) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return trips;
		}
	}

	

	
}
