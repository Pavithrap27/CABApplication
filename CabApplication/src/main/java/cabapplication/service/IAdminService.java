package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import cabapplication.dto.AdminDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CabNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;

public interface IAdminService {

	public List<AdminDTO> getAll() throws AdminNotFoundException;

	public AdminDTO save(AdminDTO adminDto) throws AdminNotFoundException;

	public AdminDTO update(AdminDTO adminDto) throws AdminNotFoundException;

	public String delete(AdminDTO adminDto) throws AdminNotFoundException;

	public AdminDTO getById(int adminId) throws AdminNotFoundException;

	public List<TripBookingDTO> getByCustomerId(int customerId) throws CustomerNotFoundException;

	public List<TripBookingDTO> getTripsCabwise() throws CabNotFoundException;

	public List<TripBookingDTO> getTripsDatewise() throws TripNotFoundException;

	public List<TripBookingDTO> getTripsCustomerwise() throws CustomerNotFoundException;

	public List<TripBookingDTO> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime ToDate)
			throws CustomerNotFoundException;
}
