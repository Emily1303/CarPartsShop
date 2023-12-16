package org.softuni.carpartsshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class CarPartsShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPartsShopApplication.class, args);
	}

//	scheduling time every day at 15 o'clock
	@Scheduled(cron = "0 0 15 * * ?")
	public void function() {
		System.out.println("Current time: " + LocalDateTime.now());
	}

}
