package com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchFlightRequest {

    private String departureAirportCityName;
    private String arrivalAirportCityName;
    private LocalDateTime departureTime;
    @Nullable
    private LocalDateTime returnTime;

}
