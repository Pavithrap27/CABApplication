package cabapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cabapplication.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
	
	
	public Customer validateCustomer(String username,String password);

}
