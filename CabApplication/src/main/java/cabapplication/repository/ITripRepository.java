package cabapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cabapplication.entity.TripBooking;

public interface ITripRepository extends JpaRepository<TripBooking,Integer> {
	

	//public TripBooking calculateBill(int customerId);

}
