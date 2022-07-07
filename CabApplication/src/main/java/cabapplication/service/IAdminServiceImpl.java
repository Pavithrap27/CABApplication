package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.dto.AdminDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
import cabapplication.exception.AdminNotFoundException;
import cabapplication.exception.CabNotFoundException;
import cabapplication.exception.CustomerNotFoundException;
import cabapplication.exception.TripNotFoundException;
import cabapplication.repository.IAdminRepository;
import cabapplication.repository.ICabRepository;
import cabapplication.repository.ICustomerRepository;
import cabapplication.repository.IDriverRepository;
import cabapplication.repository.ITripRepository;
import cabapplication.utils.Converter;


@Service	
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminrepo;
	@Autowired
	ITripRepository repo;
	
	@Override
	public List<AdminDTO> getAll() throws AdminNotFoundException {
		List<AdminDTO> adminDto = Converter.convertToDTO(adminrepo.findAll());
		if (adminDto.isEmpty()) {
			throw new AdminNotFoundException("No Admin available");
		} else {
			return adminDto;
		}
	}

	@Override
	public AdminDTO getById(int adminId) throws AdminNotFoundException {

		Admin admin = adminrepo.findById(adminId).orElseThrow();
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			return Converter.convertToDTO(admin);
		}
	}

	@Override
	public List<TripBookingDTO> getByCustomerId(int customerId) throws CustomerNotFoundException {
		List<TripBookingDTO> tripsDto = Converter.convertTripToDto(repo.getByCustomerId(customerId));
		if (tripsDto.isEmpty()) {
			throw new CustomerNotFoundException("No Customer found");
		} else {
			return tripsDto;
		}
	}

	@Override
	public List<TripBookingDTO> getTripsCabwise() throws CabNotFoundException {
		List<TripBookingDTO> trips = Converter.convertTripToDto(repo.getTripsCabwise());
		if (trips.isEmpty()) {
			throw new CabNotFoundException("Cab not found");
		} else {
			return trips;
		}
	}

	@Override
	public AdminDTO save(AdminDTO adminDto) throws AdminNotFoundException {
		if (adminDto == null) {
			throw new AdminNotFoundException("Admin Does not exist");
		} else {
			adminrepo.save(Converter.convertToEntity(adminDto));
			return adminDto;
		}

	}

	@Override
	public AdminDTO update(AdminDTO adminDto) throws AdminNotFoundException {
		if (adminDto == null) {
			throw new AdminNotFoundException("No Admin found");
		} else {
			Admin admin = Converter.convertToEntity(adminDto);
			int index = admin.getAdminId();
			Admin adminupdated = adminrepo.findById(index).orElseThrow();
			adminupdated.setEmail(admin.getEmail());
			adminupdated.setMobileNumber(admin.getMobileNumber());
			adminupdated.setPassword(admin.getPassword());
			adminupdated.setUsername(admin.getUsername());
			adminupdated.setAddress(admin.getAddress());
			adminrepo.save(adminupdated);
			return Converter.convertToDTO(adminupdated);
		}
	}

	@Override
	public String delete(AdminDTO adminDto) throws AdminNotFoundException {
		if (adminDto == null) {
			throw new AdminNotFoundException("Admin not found");
		} else {
			adminrepo.delete(Converter.convertToEntity(adminDto));
			return "Deleted";
		}
	}

	@Override
	public List<TripBookingDTO> getTripsDatewise() throws TripNotFoundException {
		List<TripBookingDTO> trips = Converter.convertTripToDto(repo.getTripsDatewise());
		if (trips.isEmpty()) {
			throw new TripNotFoundException("Customer not found");
		} else {
			return trips;
		}
	}

	@Override
	public List<TripBookingDTO> getTripsCustomerwise() throws CustomerNotFoundException {
		List<TripBookingDTO> trips = Converter.convertTripToDto(repo.getTripCustomerwise());
		if (trips.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		} else {
			return trips;
		}
	}

	@Override
	public List<TripBookingDTO> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime ToDate)
			throws CustomerNotFoundException 
	{
		List<TripBookingDTO> trips = Converter.convertTripToDto(repo.getAllTripsForDays(customerId, fromDate, ToDate));
		if (trips.isEmpty()) {
			throw new CustomerNotFoundException("Trip not found");
		} else {
			return trips;
		}
	}

}
