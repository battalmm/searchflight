package com.amadeus.yusufcankorkmaz.casestudy.searchflight.config;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.AirportDto;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.request.CreateFlightRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.user.Roles;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.user.User;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository.UserRepository;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.AirportService;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.FlightService;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.security.AuthenticationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitialDataConfig {
    
    private final PasswordEncoder passwordEncoder;

    @Bean
    @Transactional
    public CommandLineRunner initializeData(AirportService airportService,
                                            FlightService flightService,
                                            UserRepository userRepository) {
        return args -> {
            addDefaultAirports(airportService);
            addDefaultFlights(flightService);
            addDefaultAdmin(userRepository);
        };
    }
    private void addDefaultAirports(AirportService airportService) {
        for (int i = 1; i <= 30; i++) {
            AirportDto airportDto = new AirportDto("MockCity" + i);
            airportService.createAirport(airportDto);
        };
    }

    private void addDefaultFlights(FlightService flightService){
        for (int i = 1; i <= 20; i++) {
            CreateFlightRequest createFlightRequest = new CreateFlightRequest(
                    Integer.toUnsignedLong(i),
                    Integer.toUnsignedLong(i+1),
                    100D,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusDays(Integer.toUnsignedLong(i))
            );
            flightService.createFlight(createFlightRequest);
        };
    }

    private void addDefaultAdmin(UserRepository userRepository){
        if (userRepository.count() == 0) {
            User admin = new User(
                    "admin",
                    "admin",
                    passwordEncoder.encode("admin"),
                    "admin@admin.com",
                    Roles.ADMIN
            );
            userRepository.save(admin);
        }
    }
}