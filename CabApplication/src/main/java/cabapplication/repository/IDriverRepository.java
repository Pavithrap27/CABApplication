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

	@Query("select trip from TripBooking trip where driver=?1")
	public List<TripBooking> getByDriver(Driver driver);
	@Query("Select driver from Driver driver where cab.carType=?1")
    public Driver getByCarType(String carType); 



}
