package cabapplication.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;
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
import cabapplication.repository.ICustomerRepository;

import cabapplication.repository.IDriverRepository;
import cabapplication.repository.ITripRepository;
import cabapplication.utils.Converter;

@Service
public class AdminServiceImpl implements IAdminService {

		@Autowired
		IAdminRepository adminrepo;
		@Autowired
		ITripRepository repo;
		@Autowired
		ICustomerRepository customerrepo;
		@Autowired
		IDriverRepository driverRepo;

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
		public AdminDTO getById(int adminId) throws Throwable {
			Supplier<AdminNotFoundException> s1 = () -> new AdminNotFoundException("Admin not found");
			return Converter.convertToDTO(adminrepo.findById(adminId).orElseThrow(s1));
		}

		@Override
		public List<TripBookingDTO> getByCustomerId(int customerId) throws Throwable {
			List<TripBookingDTO> list = Converter.convertTripToDto(repo.getByCustomerId(customerId));
			if ((list.isEmpty())) {
				throw new CustomerNotFoundException("Customer does not exist");
			}
				return list;
			
			
			
		}

		@Override
		public AdminDTO save(AdminDTO adminDto) throws Throwable {
			if (adminDto.getUsername() != null) {
				adminrepo.save(Converter.convertToEntity(adminDto));
				return adminDto;
			}
			throw new AdminNotFoundException("Admin not available");

		}

		@Override
		public AdminDTO update(AdminDTO adminDto) throws Throwable {
			Admin admin = Converter.convertToEntity(adminDto);
			int id = admin.getAdminId();

			Supplier<AdminNotFoundException> s1 = () -> new AdminNotFoundException("Admin not found");

			Admin adminupdated = adminrepo.findById(id).orElseThrow(s1);
			adminupdated.setEmail(admin.getEmail());
			adminupdated.setMobileNumber(admin.getMobileNumber());
			adminupdated.setPassword(admin.getPassword());
			adminupdated.setUsername(admin.getUsername());
			adminupdated.setAddress(admin.getAddress());
			adminrepo.save(adminupdated);
			return Converter.convertToDTO(adminupdated);
		}

		@Override
		public String delete(int adminId) throws Throwable {
			Supplier<AdminNotFoundException> s1 = () -> new AdminNotFoundException("Admin not found");
			adminrepo.findById(adminId).orElseThrow(s1);
			adminrepo.deleteById(adminId);
			return "Deleted";
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
		public List<TripBookingDTO> getAllTripsForDays(int customerId,  LocalDateTime  fromDate,  LocalDateTime  toDate)
				throws CustomerNotFoundException {
			List<TripBookingDTO> trips = Converter.convertTripToDto(repo.getAllTripsForDays(customerId, fromDate, toDate));
			if (trips.isEmpty()) {
				throw new CustomerNotFoundException("Trip not found");
			} else {
				return trips;
			}
		}

	}
