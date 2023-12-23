package com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByDepartureTimeBetweenAndDepartureAirportCityNameAndArrivalAirportCityName(LocalDateTime startOfDayTime, LocalDateTime endOfDayTime, String departureAirport, String arrivalAirport);
}
