package cabapplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import cabapplication.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer getByUsernameAndPassword(String username, String password);
	
}
