package com.amadeus.yusufcankorkmaz.casestudy.searchflight;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.AirportDto;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.AirportService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner initializeData(AirportService airportService) {
		return args -> {
			addDefaultAirports(airportService);
		};
	}
	private void addDefaultAirports(AirportService airportService) {
		for (int i = 1; i <= 30; i++) {
			AirportDto airportDto = new AirportDto("MockCity" + i);
			airportService.createAirport(airportDto);
			};
		}
	}
