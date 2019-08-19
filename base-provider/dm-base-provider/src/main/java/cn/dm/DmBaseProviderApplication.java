package cn.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DmBaseProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmBaseProviderApplication.class, args);
	}
}
