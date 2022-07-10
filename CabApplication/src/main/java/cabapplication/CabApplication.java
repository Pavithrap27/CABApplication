package cabapplication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CabApplication {
	static Log logger = LogFactory.getLog(CabApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CabApplication.class, args);
		logger.info("connected to data base");
	}

    @Bean
    public Docket productApi() 
    {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("cabapplication")).build();
    }
	
	//http://localhost:9090/swagger-ui/index.html
}
