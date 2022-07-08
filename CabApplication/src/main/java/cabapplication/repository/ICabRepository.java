package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import cabapplication.entity.Cab;
import cabapplication.entity.Driver;

public interface ICabRepository extends JpaRepository<Cab, Integer> {

	@Query("Select cabs from Cab cabs where carType=?1")
	public List<Cab> viewCabsOfType(String carType);

	@Query("select COUNT(cab) from Cab cab where carType=?1 ")
	public int countCabsOfType(String carType);

	
	@Query("Select driver from Driver driver where cab.carType=?1")
    public Driver getByCarType(String carType); 

}
