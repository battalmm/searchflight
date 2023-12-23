package com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchFlightResponse {

    private List<FlightDto> departureFlights;
    private List<FlightDto> returnFlights;
}
