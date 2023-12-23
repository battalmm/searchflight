package com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Airport;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Flight;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    @ManyToOne( fetch = FetchType.LAZY)
    private Long departureAirportId;
    @ManyToOne( fetch = FetchType.LAZY)
    private Long arrivalAirportId;

    public static FlightDto convertFlightToDto(Flight flight){
        return new FlightDto(
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getPrice(),
                flight.getDepartureAirport().getId(),
                flight.getArrivalAirport().getId()
        );
    }
}
