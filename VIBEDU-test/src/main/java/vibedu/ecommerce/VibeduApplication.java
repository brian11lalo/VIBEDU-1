package vibedu.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication	
(exclude = {DataSourceAutoConfiguration.class })
public class VibeduApplication {

	public static void main(String[] args) {
		SpringApplication.run(VibeduApplication.class, args);
	}

}
