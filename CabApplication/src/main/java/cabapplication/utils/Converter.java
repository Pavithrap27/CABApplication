package cabapplication.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cabapplication.dto.AdminDTO;
import cabapplication.dto.DriverDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
import cabapplication.entity.Driver;
import cabapplication.entity.TripBooking;

public class Converter {
	public static AdminDTO convertToDTO(Admin admin)
	{
		AdminDTO admindto=new AdminDTO();
		BeanUtils.copyProperties(admin, admindto);
		return admindto;
		
	}
	public static List<AdminDTO> convertToDTO(List<Admin> list)
	{
		List<AdminDTO> listDto =new ArrayList<>();
		for(Admin admin:list)
		{
			listDto.add(convertToDTO(admin));
			
		}
		return listDto;
	}
	public static Admin convertToEntity(AdminDTO adminDto)
	{
		Admin admin=new Admin();
		BeanUtils.copyProperties(adminDto, admin);
		return admin;
	}
	public static List<Admin> convertToEntity(List<AdminDTO> listDto)
	{

		List<Admin> list =new ArrayList<>();
		for(AdminDTO adminDto:listDto)
		{
			list.add(convertToEntity(adminDto));
			
		}
		return list;
		
	}
	public static List<TripBookingDTO> convertTripToDto(List<TripBooking> trips)
	{

		List<TripBookingDTO> tripsDto =new ArrayList<>();
		for(TripBooking trip:trips)
		{
			tripsDto.add(convertTripToDto(trip));
			
		}
		return tripsDto;
		
	}
	public static TripBookingDTO convertTripToDto(TripBooking trip)
	{
		TripBookingDTO tripDto=new TripBookingDTO();
		BeanUtils.copyProperties(trip,tripDto);
		return tripDto;
		
	}
	public static TripBooking convertTripToEntity(TripBookingDTO tripDto)
	{
		TripBooking trips=new TripBooking();
		BeanUtils.copyProperties(tripDto, trips);
		return trips;
	}
	public static List<TripBooking> convertTripToEntity(List<TripBookingDTO> tripDto)
	{
		List<TripBooking> trip=new ArrayList<>();
		for(TripBookingDTO dto:tripDto)
		{
			trip.add(convertTripToEntity(dto));
			
		}
		return trip;
	}
	
	
	public static DriverDTO convertDriverToDTO(Driver driver)
	{
		DriverDTO driverd=new DriverDTO();
		driverd.setUsername(driver.getUsername());
		driverd.setPassword(driver.getPassword());
		driverd.setAddress(driver.getAddress());
		driverd.setCab(driver.getCab());
		driverd.setDriverId(driver.getDriverId());
		driverd.setEmail(driver.getEmail());
		driverd.setMobileNumber(driver.getMobileNumber());
		driverd.setLicenceNo(driver.getLicenceNo());
		driverd.setRating(driver.getRating());
		return driverd;
	}
	public static Driver convertDriverToEntity(DriverDTO driverDto)
	{
		Driver driverd=new Driver();
		driverd.setUsername(driverDto.getUsername());
		driverd.setPassword(driverDto.getPassword());
		driverd.setAddress(driverDto.getAddress());
		driverd.setCab(driverDto.getCab());
		driverd.setDriverId(driverDto.getDriverId());
		driverd.setEmail(driverDto.getEmail());
		driverd.setMobileNumber(driverDto.getMobileNumber());
		driverd.setLicenceNo(driverDto.getLicenceNo());
		driverd.setRating(driverDto.getRating());
		return driverd;
	}

}
