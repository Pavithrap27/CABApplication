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
import cabapplication.repository.ITripRepository;
import cabapplication.utils.Converter;


@Service	
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminrepo;
	@Autowired
	ITripRepository repo;
	@Autowired
	ICustomerRepository customerrepo;
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
	public AdminDTO getById(int adminId) throws Throwable 
	{
		Supplier s1=()-> new AdminNotFoundException("Admin not found");
		return Converter.convertToDTO(adminrepo.findById(adminId).orElseThrow(s1)); 
	}

	@Override
	public List<TripBookingDTO> getByCustomerId(int customerId) throws Throwable 
	{
		List<TripBookingDTO> list=Converter.convertTripToDto(repo.getByCustomerId(customerId));
        if(!(list.isEmpty()))
        {
            return list;
        }
        else{
            throw new CustomerNotFoundException("Customer does not exist");
        }
	}

	@Override
	public List<TripBookingDTO> getTripsCabwise() throws Throwable 
	{
		Supplier s1=()-> new CabNotFoundException("Cab not found");
		return Converter.convertTripToDto(repo.getTripsCabwise());
	}

	@Override
	public AdminDTO save(AdminDTO adminDto) throws Throwable 
	{
		Supplier s1=()->new AdminNotFoundException("Admin not available");
		int adminId=adminDto.getAdminId();
		AdminDTO admin=Converter.convertToDTO(adminrepo.findById(adminId).orElseThrow(s1));

		adminrepo.save(Converter.convertToEntity(adminDto));
		return adminDto;
		
	}

	@Override
	public AdminDTO update(AdminDTO adminDto) throws Throwable 
	{
			Admin admin = Converter.convertToEntity(adminDto);
			int index = admin.getAdminId();
			
			Supplier s1=()-> new AdminNotFoundException("Admin not found");
			
			Admin adminupdated = adminrepo.findById(index).orElseThrow();
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
			Supplier s1=()-> new AdminNotFoundException("Admin not found");
			Admin admin = adminrepo.findById(adminId).orElseThrow(s1);
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
