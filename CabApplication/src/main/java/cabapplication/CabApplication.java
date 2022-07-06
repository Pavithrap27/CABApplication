package cabapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class CabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabApplication.class, args);
		System.out.println("Connected to data base");
	}
	

}
