package cabapplication.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.dto.TripBookingDTO;
import cabapplication.entity.TripBooking;

public interface ITripRepository extends JpaRepository<TripBooking, Integer> {

	public List<TripBooking> getByCustomerId(int customerId);

	public TripBooking findByCustomerId(int customerId);
	
	@Query("Select trips from TripBooking trips where customerId=?1 AND fromDateTime=?2 AND toDateTime=?3")
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);

	@Query("Select trips from TripBooking trips ORDER BY fromDateTime ")
	public List<TripBooking> getTripsDatewise();
	@Query("Select trips from TripBooking trips ORDER BY customerId")
	public List<TripBooking> getTripCustomerwise();

}
