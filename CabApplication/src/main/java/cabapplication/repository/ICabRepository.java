package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.entity.Cab;

public interface ICabRepository extends JpaRepository<Cab,Integer> {
	
	@Query("select cabs from Cab cabs where cartype=?1")
	public List<Cab> viewCabsOfType(String carType);
	@Query("select COUNT(cab)from Cab cab where carType=?1 ")
	public int countCabsOfType(String carType);
	
}
