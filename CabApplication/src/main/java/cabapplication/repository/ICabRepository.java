package cabapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cabapplication.entity.Cab;

public interface ICabRepository extends JpaRepository<Cab,Integer>{

}
