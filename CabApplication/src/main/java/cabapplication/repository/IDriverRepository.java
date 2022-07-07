package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.dto.DriverDTO;
import cabapplication.entity.Driver;

public interface IDriverRepository extends JpaRepository<Driver,Integer> {
	@Query("Select d from Driver d where rating>=4.5")
	public List<Driver> viewBestDrivers();

}
