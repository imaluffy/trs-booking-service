package com.trs.trs_booking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrsBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrsBookingServiceApplication.class, args);
		System.out.println("Hellow from booking service");
	}

}
