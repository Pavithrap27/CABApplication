package cabapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cabapplication.entity.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
	
	@Query("select c from Customer c where username=?1 and password=?2")
	public Customer validateCustomer(String username,String password);
	
	  //public Customer getByName(String username);

}
