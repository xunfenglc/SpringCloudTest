package com.tedu.sp05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.client.RestTemplate;

@EnableEurekaServer
@SpringBootApplication
public class Sp05EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp05EurekaApplication.class, args);
	}

}
