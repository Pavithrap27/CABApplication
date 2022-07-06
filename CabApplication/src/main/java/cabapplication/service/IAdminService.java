package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.exception.AdminNotFoundException;
@Service
public interface IAdminService {
	
	public Admin getAdmin() throws AdminNotFoundException;
	public Admin insertAdmin(Admin admin) throws AdminNotFoundException;
	public Admin updateAmin(Admin admin)throws AdminNotFoundException;
	public String deleteAdmin(Admin admin)throws AdminNotFoundException;
	public Admin viewAdmin(int adminId) throws AdminNotFoundException;
	public List<TripBooking>getAllTrips(int customerId) throws AdminNotFoundException;
	public List<TripBooking>getTripsCabwise() throws AdminNotFoundException;
	public List<TripBooking>getTripsDatewise() throws AdminNotFoundException;
	public List<TripBooking>getTripsCustomerwise() throws AdminNotFoundException;
	public List<TripBooking>getAllTripsForDays()throws AdminNotFoundException;
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException;
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime ToDate)
			throws AdminNotFoundException;
	
}
