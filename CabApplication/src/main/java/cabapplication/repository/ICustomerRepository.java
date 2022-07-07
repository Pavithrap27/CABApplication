package cabapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cabapplication.entity.Customer;
import cabapplication.entity.TripBooking;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	/*
	 * @Query("select c from Customer c where username=?1 and password=?2") public
	 * Customer validateCustomer(String username, String password);
	 */
	
	public Customer getByUserNameAndPassword(String username, String password);
	@Query("select c from Customer c where username=?1 and password=?2")
	public Customer validateCustomer(String username, String password);
	@Query("Select trips from TripBooking trips ORDER BY customerId")
	public List<TripBooking> getTripCustomerwise();

}
