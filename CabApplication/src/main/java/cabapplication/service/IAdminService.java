package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.repository.IAdminRepository;

@Service
public class IAdminService {
	
	@Autowired
	IAdminRepository adminrepo;
	ITripService tripservice;
	
	public Admin insertAdmin(Admin admin)
	{
		adminrepo.save(admin);
		return admin;
	}
	
	public Admin updateAdmin(Admin admin)
	{
		int index=admin.getAdminId();
		Admin adminupdated=adminrepo.findById(index).orElseThrow();
	    adminupdated.setEmail(admin.getEmail());
	    adminupdated.setMobileNumber(admin.getMobileNumber());
	    adminupdated.setPassword(admin.getPassword());
	    adminupdated.setUsername(admin.getUsername());
		adminrepo.save(adminupdated);
		return admin;
	}
	
	public Admin deleteAdmin(Admin admin)
	{ 
		adminrepo.delete(admin);
		return admin;
		
	}
	
	public Admin viewAdmin(int adminId) 
	{
		return adminrepo.findById(adminId).get();
	}
	
	public List<TripBooking> getAllTrips(int customerId)
	{
		List<TripBooking> trips=tripservice.viewAllTrips(customerId);
		return trips;
	}
	
	public List<TripBooking> getTripsCabwise()
	{
		List<TripBooking> trips=adminrepo.getTripsCabwise();
		return trips;
	}
	
	public List<TripBooking> getTripsDatewise()
	{
		List<TripBooking> trips=adminrepo.getTripsDatewise();
		return trips;
	}
	
	public List<TripBooking> getTripsCustomerwise()
	{
		List<TripBooking> trips =adminrepo.getTripCustomerwise();
		return trips;
	}
	
	public List<TripBooking> getAllTripsForDays(int customerId,LocalDateTime fromDate,LocalDateTime ToDate)
	{
		List<TripBooking> trips=adminrepo.getAllTripsForDays(customerId, fromDate, ToDate);
		return trips;
	}
}
