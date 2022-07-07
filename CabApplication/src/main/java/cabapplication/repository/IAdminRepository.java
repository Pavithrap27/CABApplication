package cabapplication.repository;




import org.springframework.data.jpa.repository.JpaRepository;


import cabapplication.entity.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	

}
