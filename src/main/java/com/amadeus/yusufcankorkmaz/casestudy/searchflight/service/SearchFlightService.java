package com.amadeus.yusufcankorkmaz.casestudy.searchflight.service;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.FlightDto;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.request.SearchFlightRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.response.SearchFlightResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchFlightService {

    private final FlightService flightService;

    public SearchFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    public SearchFlightResponse searchFlights(SearchFlightRequest searchFlightRequest){

        SearchFlightResponse searchFlightResponse = new SearchFlightResponse(
                Collections.emptyList(),
                Collections.emptyList());


        boolean isOneWayFlight = searchFlightRequest.getReturnTime() == null;

        List<FlightDto> departureFlights = flightService.findFlightsFilteredDay(
                searchFlightRequest.getDepartureAirportCityName(),
                searchFlightRequest.getArrivalAirportCityName(),
                searchFlightRequest.getDepartureTime());
        searchFlightResponse.setDepartureFlights(departureFlights);

        if(!isOneWayFlight){
            List<FlightDto> returnFlights = flightService.findFlightsFilteredDay(
                    searchFlightRequest.getArrivalAirportCityName(),
                    searchFlightRequest.getDepartureAirportCityName(),
                    searchFlightRequest.getReturnTime());
            searchFlightResponse.setReturnFlights(returnFlights);
        }

        return searchFlightResponse;
    }
}
