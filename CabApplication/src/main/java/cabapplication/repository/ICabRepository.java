package cabapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.entity.Cab;

public interface ICabRepository extends JpaRepository<Cab,Integer> {
	
	@Query("select cabs from Cab cabs where cartype=?1")
	public List<Cab> viewCabsOfType(String carType);
	@Query("select count(*),car_type from Cab cabs group by car_type")
	 public int countCabsOfType(int cabId);
	
	@Query("select COUNT(cab) from Cab cab where carType=?1 ")
	public int countCabsOfType(String carType);


	
}
