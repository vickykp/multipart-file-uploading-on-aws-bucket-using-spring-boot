package craterzone.com.vivek.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient

@SpringBootApplication
public class UserProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProductsApplication.class, args);
	}

}
