package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cabapplication.entity.Cab;

public interface ICabService extends JpaRepository<Cab,Integer> {
	

}
