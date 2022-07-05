package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.entity.TripBooking;

public interface ITripRepository extends JpaRepository<TripBooking,Integer> {
	//@Query("Select trips from TripBooking trips where customerId=?1")
	public List<TripBooking> getByCustomerId(int customerId);
	
	public TripBooking findByCustomerId(int customerId);

}
