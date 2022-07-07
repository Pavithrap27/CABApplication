package cabapplication.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cabapplication.dto.AdminDTO;
<<<<<<< HEAD
import cabapplication.dto.CustomerDTO;
=======
import cabapplication.dto.DriverDTO;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git
import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.Admin;
<<<<<<< HEAD
import cabapplication.entity.Customer;
=======
import cabapplication.entity.Driver;
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git
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
	
<<<<<<< HEAD
	public static CustomerDTO convertCustomerToDto(Customer customer)
	{
		CustomerDTO customerto=new CustomerDTO();
		BeanUtils.copyProperties(customer, customerto);
		return customerto;
		
	}
	public static List<CustomerDTO> convertCustomersToDTO(List<Customer> customers)
	{
		List<CustomerDTO> listDto =new ArrayList<>();
		for(Customer customer:customers)
		{
			listDto.add((CustomerDTO) convertCustomersToDTO(customers));
		}
		return listDto;
	}
	public static Customer convertCustomerToEntity(CustomerDTO customerDto)
	{
		Customer customer=new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		return customer;
	}
	
	public static List<Customer> convertCustomerstToEntity(List<CustomerDTO> listDto)
	{

		List<Customer> list =new ArrayList<>();
		for(CustomerDTO customerDto:listDto)
		{
			list.add(convertCustomerToEntity(customerDto));
			
		}
		return list;
	}
=======
	public static DriverDTO convertDriverToDTO(Driver driver)
	{
		DriverDTO driverdto=new DriverDTO();
		BeanUtils.copyProperties(driver, driverdto);
		return driverdto;
		
	}
	public static List<DriverDTO> convertDriverToDTO(List<Driver> list)
	{
		List<DriverDTO> listDto =new ArrayList<>();
		for(Driver driver:list)
		{
			listDto.add(convertDriverToDTO(driver));
			
		}
		return listDto;
	}
	public static Driver convertDriverDtoToEntity(DriverDTO driverDto)
	{
		Driver driver=new Driver();
		BeanUtils.copyProperties(driverDto, driver);
		return driver;
	}
	public static List<Driver> convertDriverDtoToEntity(List<DriverDTO> listDto)
	{

		List<Driver> list =new ArrayList<>();
		for(DriverDTO driverDto:listDto)
		{
			list.add(convertDriverDtoToEntity(driverDto));
			
		}
		return list;
		
	}

	
>>>>>>> branch 'master' of https://github.com/Pavithrap27/CABApplication.git

}
