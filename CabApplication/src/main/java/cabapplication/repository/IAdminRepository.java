package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cabapplication.entity.Admin;
import cabapplication.entity.Customer;
import cabapplication.entity.TripBooking;

public interface IAdminRepository extends JpaRepository<Admin,Integer> {
	public List<TripBooking> getTripsCabwise();
	public List<TripBooking> getTripsCustomerwise();
	public List<TripBooking> getTripsDatewise();
	

}
