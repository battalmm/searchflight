package com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlightRequest {

    private Long departureAirportId;
    private Long arrivalAirportId;
    private Double price;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

}
