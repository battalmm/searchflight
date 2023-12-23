package com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDto {

    private String cityName;

    public static AirportDto airportToDto(Airport airport){
        return new AirportDto(airport.getCityName());
    }

}
