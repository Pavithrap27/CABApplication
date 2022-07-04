package cabapplication.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.entity.Admin;
import cabapplication.entity.Customer;
import cabapplication.entity.TripBooking;

public interface IAdminRepository extends JpaRepository<Admin,Integer> {
	public List<TripBooking> getTripsCabwise();
	public List<TripBooking> getTripsCustomerwise();
	public List<TripBooking> getTripsDatewise();
	@Query("Select trips from TripBooking trips where customerId=? AND fromDate=? AND toDate=?")
	public List<TripBooking> getAllTripsForDays(int customerId,LocalDateTime fromDate,LocalDateTime toDate);
	

}
