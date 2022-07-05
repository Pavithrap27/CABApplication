package cabapplication.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.entity.Admin;
import cabapplication.entity.Customer;
import cabapplication.entity.TripBooking;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	@Query("Select trips from TripBooking trips where customerId=?1 AND fromDateTime=?2 AND toDateTime=?3")
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);

	@Query("Select trips from TripBooking trips ORDER BY carType")
	public List<TripBooking> getTripsCabwise();

	@Query("Select trips from TripBooking trips ORDER BY customerId")
	public List<TripBooking> getTripCustomerwise();

	@Query("Select trips from TripBooking trips ORDER BY fromDateTime ")
	public List<TripBooking> getTripsDatewise();

}
