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

	public List<AdminDTO> getAll() throws AdminNotFoundException;

	public AdminDTO save(AdminDTO adminDto) throws AdminNotFoundException;

<<<<<<< HEAD
	
	public AdminDTO update(Admin admin) throws AdminNotFoundException;
=======
	public AdminDTO update(AdminDTO adminDto) throws AdminNotFoundException;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

	public String delete(AdminDTO adminDto) throws AdminNotFoundException;

	
	public AdminDTO getById(int adminId) throws AdminNotFoundException;

	
	public List<TripBookingDTO> getByCustomerId(int customerId) throws CustomerNotFoundException;

	public List<TripBookingDTO> getTripsCabwise() throws CabNotFoundException;

	public List<TripBookingDTO> getTripsDatewise() throws TripNotFoundException;

	public List<TripBookingDTO> getTripsCustomerwise() throws CustomerNotFoundException;

	public List<TripBookingDTO> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime ToDate)
			throws CustomerNotFoundException;
}
