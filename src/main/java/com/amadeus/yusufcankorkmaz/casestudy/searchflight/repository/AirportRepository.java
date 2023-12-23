package com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> getAirportByCityName(String cityName);
}
