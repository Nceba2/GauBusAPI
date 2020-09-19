package com.gaubusapi.GauBusAPI;

import Controller.RequestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GauBusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestController.class, args);
	}

}
