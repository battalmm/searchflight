package com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
