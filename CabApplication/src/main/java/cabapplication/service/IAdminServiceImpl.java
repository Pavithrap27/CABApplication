package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.dto.AdminDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CabNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.IAdminRepository;
import cabapplication.utils.Converter;

@Service
public abstract class IAdminServiceImpl implements IAdminService {
	@Autowired
	IAdminRepository adminrepo;
	@Autowired
	ITripService tripservice;
	Converter converter;

	public List<AdminDTO> getAll() throws AdminNotFoundException {
		List<AdminDTO> adminDto = converter.convertToDTO(adminrepo.findAll());
		if (adminDto.isEmpty()) {
			throw new AdminNotFoundException("No Admin available");
		} else {
			return adminDto;
		}
	}

	public AdminDTO save(AdminDTO adminDto) throws AdminNotFoundException {
		if (adminDto == null) {
			throw new AdminNotFoundException("Admin Does not exist");
		} else {
			adminrepo.save(converter.convertToEntity(adminDto));
			return adminDto;
		}

	}

	public AdminDTO updateAdmin(AdminDTO adminDto) throws AdminNotFoundException {
		if (adminDto == null) {
			throw new AdminNotFoundException("No Admin found");
		} else {
			Admin admin = converter.convertToEntity(adminDto);
			int index = admin.getAdminId();
			Admin adminupdated = adminrepo.findById(index).orElseThrow();
			adminupdated.setEmail(admin.getEmail());
			adminupdated.setMobileNumber(admin.getMobileNumber());
			adminupdated.setPassword(admin.getPassword());
			adminupdated.setUsername(admin.getUsername());
			adminupdated.setAddress(admin.getAddress());
			adminrepo.save(adminupdated);
			return converter.convertToDTO(adminupdated);
		}
	}

	public String delete(AdminDTO adminDto) throws AdminNotFoundException {
		if (adminDto == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			adminrepo.delete(converter.convertToEntity(adminDto));
			return "Deleted";
		}

	}

	public AdminDTO getById(int adminId) throws AdminNotFoundException {

		Admin admin = adminrepo.findById(adminId).orElseThrow();
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return converter.convertToDTO(admin);
		}
	}

	public List<TripBookingDTO> getAllTrips(int customerId) throws CustomerNotFoundException {
		List<TripBookingDTO> tripsDto =tripservice.getByCustomerId(customerId);
		if (tripsDto.isEmpty()) {
			throw new CustomerNotFoundException("No Customer found");
		} else {
			return tripsDto;
		}
	}

	public List<TripBookingDTO> getTripsCabwise() throws CabNotFoundException {
		List<TripBookingDTO> trips = converter.convertTripToDto(adminrepo.getTripsCabwise());
		if (trips.isEmpty()) {
			throw new CabNotFoundException("Cab not found");
		} else {
			return trips;
		}
	}

	public List<TripBookingDTO> getTripsDatewise() throws TripNotFoundException {
		List<TripBookingDTO> trips = converter.convertTripToDto(adminrepo.getTripsDatewise());
		if (trips.isEmpty()) {
			throw new TripNotFoundException("Trip not found");
		} else {
			return trips;
		}

	}

	public List<TripBookingDTO> getTripsCustomerwise() throws CustomerNotFoundException {
		List<TripBookingDTO> trips = converter.convertTripToDto(adminrepo.getTripCustomerwise());
		if (trips.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			return trips;
		}
	}

	public List<TripBookingDTO> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException {
		List<TripBookingDTO> trips = converter
				.convertTripToDto(adminrepo.getAllTripsForDays(customerId, fromDate, toDate));
		if (trips.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			return trips;
		}
	}

}
