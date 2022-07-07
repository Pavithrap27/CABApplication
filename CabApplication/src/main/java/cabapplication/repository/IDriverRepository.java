package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.entity.Cab;
import cabapplication.entity.Driver;
import cabapplication.entity.TripBooking;

public interface IDriverRepository extends JpaRepository<Driver,Integer> {
	@Query("Select d from Driver d where rating>=4.5")
	public List<Driver> viewBestDrivers();
	public Driver getByUsernameAndPassword(String username, String password);
	
	@Query("Select trips from TripBooking trips where carType=?1")
	public List<TripBooking> getTripBookingBycarType(String carType);

}
