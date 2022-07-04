package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cabapplication.entity.Cab;

public interface ICabService extends JpaRepository<Cab,Integer> {
	
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);

}
