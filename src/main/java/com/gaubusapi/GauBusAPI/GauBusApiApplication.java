package com.gaubusapi.GauBusAPI;

import Controller.RequestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GauBusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestController.class, args);
	}

}
