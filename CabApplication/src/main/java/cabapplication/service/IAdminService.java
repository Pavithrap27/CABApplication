package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CabNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.IAdminRepository;

@Service
public class IAdminService {

	@Autowired
	IAdminRepository adminrepo;
	ITripService tripservice;

	public List<Admin> getAdmin() throws AdminNotFoundException {
		List<Admin> admin = adminrepo.findAll();
		if (admin.isEmpty()) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return admin;
		}
	}

	public Admin insertAdmin(Admin admin) throws AdminNotFoundException {
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			adminrepo.save(admin);
			return admin;
		}

	}

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

	public String deleteAdmin(Admin admin) throws AdminNotFoundException {
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			adminrepo.delete(admin);
			return "Deleted";
		}

	}

	public Admin viewAdmin(int adminId) throws AdminNotFoundException {

		Admin admin = adminrepo.findById(adminId).orElseThrow();
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return admin;
		}
	}

	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException {
		List<TripBooking> trips = tripservice.viewAllTrips(customerId);
		if (trips.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			return trips;
		}
	}

	public List<TripBooking> getTripsCabwise() throws CabNotFoundException {
		List<TripBooking> trips = adminrepo.getTripsCabwise();
		if (trips.isEmpty()) {
			throw new CabNotFoundException("Cab not found");
		} else {
			return trips;
		}
	}

	public List<TripBooking> getTripsDatewise() throws TripNotFoundException {
		List<TripBooking> trips = adminrepo.getTripsDatewise();
		if (trips.isEmpty()) {
			throw new TripNotFoundException("Trip not found");
		} else {
			return trips;
		}

	}

	public List<TripBooking> getTripsCustomerwise() throws CustomerNotFoundException {
		List<TripBooking> trips = adminrepo.getTripCustomerwise();
		if (trips.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			return trips;
		}
	}

	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime ToDate)
			throws CustomerNotFoundException {
		List<TripBooking> trips = adminrepo.getAllTripsForDays(customerId, fromDate, ToDate);
		if (trips.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			return trips;
		}
	}
}
