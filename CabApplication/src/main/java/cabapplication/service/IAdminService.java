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

	public AdminDTO save(AdminDTO adminDto) throws Throwable;

	public AdminDTO update(AdminDTO adminDto) throws Throwable;

	public String delete(int adminId) throws Throwable;

	public AdminDTO getById(int adminId) throws Throwable;

	public List<TripBookingDTO> getByCustomerId(int customerId) throws Throwable;

	public List<TripBookingDTO> getTripsCabwise() throws Throwable;

	public List<TripBookingDTO> getTripsDatewise() throws TripNotFoundException;

	public List<TripBookingDTO> getTripsCustomerwise() throws CustomerNotFoundException;

	public List<TripBookingDTO> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime ToDate)
			throws CustomerNotFoundException;
}
