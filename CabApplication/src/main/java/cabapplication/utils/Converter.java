package cabapplication.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cabapplication.dto.AdminDTO;
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
import cabapplication.entity.TripBooking;

public class Converter {
	public AdminDTO convertToDTO(Admin admin)
	{
		AdminDTO admindto=new AdminDTO();
		BeanUtils.copyProperties(admin, admindto);
		return admindto;
		
	}
	public List<AdminDTO> convertToDTO(List<Admin> list)
	{
		List<AdminDTO> listDto =new ArrayList<>();
		for(Admin admin:list)
		{
			listDto.add(convertToDTO(admin));
			
		}
		return listDto;
	}
	public Admin convertToEntity(AdminDTO adminDto)
	{
		Admin admin=new Admin();
		BeanUtils.copyProperties(adminDto, admin);
		return admin;
	}
	public List<Admin> convertToEntity(List<AdminDTO> listDto)
	{

		List<Admin> list =new ArrayList<>();
		for(AdminDTO adminDto:listDto)
		{
			list.add(convertToEntity(adminDto));
			
		}
		return list;
		
	}
	public List<TripBookingDTO> convertTripToDto(List<TripBooking> trips)
	{

		List<TripBookingDTO> tripsDto =new ArrayList<>();
		for(TripBooking trip:trips)
		{
			tripsDto.add(convertTripToDto(trip));
			
		}
		return tripsDto;
		
	}
	public TripBookingDTO convertTripToDto(TripBooking trip)
	{
		TripBookingDTO tripDto=new TripBookingDTO();
		BeanUtils.copyProperties(trip,tripDto);
		return tripDto;
		
	}
	public TripBooking convertTripToEntity(TripBookingDTO tripDto)
	{
		TripBooking trips=new TripBooking();
		BeanUtils.copyProperties(tripDto, trips);
		return trips;
	}
	public List<TripBooking> convertTripToEntity(List<TripBookingDTO> tripDto)
	{
		List<TripBooking> trip=new ArrayList<>();
		for(TripBookingDTO dto:tripDto)
		{
			trip.add(convertTripToEntity(dto));
			
		}
		return trip;
	}

}
