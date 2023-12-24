package com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.request;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlightRequest {

    private Long departureAirportId;
    private Long arrivalAirportId;
    private Double price;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

}
