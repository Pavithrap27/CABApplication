package cabapplication.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.service.IAdminService;

@RestController
@RequestMapping("admin")
public class IAdminController {
	
	@Autowired
	IAdminService adminservice;
	
	@GetMapping("getAdmin")
	public List<Admin> getAdmin()
	{
		return adminservice.getAdmin();
	}
	
	@PostMapping("insertAdmin")
	public Admin insertAdmin(@RequestBody Admin admin)
	{
		adminservice.insertAdmin(admin);
		return admin;
	}
	
	@PutMapping("updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin)
	{
		adminservice.updateAdmin(admin);
		return admin;
	}
	
	@DeleteMapping("deleteAdmin")
	public String deleteAdmin(@RequestBody Admin admin)
	{ 
		adminservice.deleteAdmin(admin);
		return "Deleted";
	}
	
	@GetMapping("viewAdmin/{adminId}")
	public Admin viewAdmin(@PathVariable int adminId) 
	{
		return adminservice.viewAdmin(adminId);
	}
	
	@GetMapping("getAllTrips/{customerId}")
	public List<TripBooking> getAllTrips(@PathVariable int customerId)
	{
		List<TripBooking> trips=adminservice.getAllTrips(customerId);
		return trips;
	}
	
	@GetMapping("getTripsCabwise")
	public List<TripBooking> getTripsCabwise()
	{
		List<TripBooking> trips=adminservice.getTripsCabwise();
		return trips;
	}
	
	@GetMapping("getTripsDatewise")
	public List<TripBooking> getTripsDatewise()
	{
		List<TripBooking> trips=adminservice.getTripsDatewise();
		return trips;
	}
	
	@GetMapping("getTripsCustomerwise")
	public List<TripBooking> getTripsCustomerwise()
	{
		List<TripBooking> trips =adminservice.getTripsCustomerwise();
		return trips;
	}
	
	@GetMapping("getAllTripsForDays")
	public List<TripBooking> getAllTripsForDays(@PathVariable int customerId,@PathVariable LocalDateTime fromDate,@PathVariable LocalDateTime ToDate)
	{
		List<TripBooking> trips=adminservice.getAllTripsForDays(customerId, fromDate, ToDate);
		return trips;
	}
}
