package com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchFlightRequest {

    private String departureAirportCityName;
    private String arrivalAirportCityName;
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate departureTime;
    @Nullable
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate returnTime;

}
