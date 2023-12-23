package com.amadeus.yusufcankorkmaz.casestudy.searchflight.service;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.FlightDto;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.SearchFlightRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.SearchFlightResponse;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Flight;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchFlightService {

    private final FlightService flightService;

    public SearchFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    public SearchFlightResponse searchFlights(SearchFlightRequest searchFlightRequest){

        SearchFlightResponse searchFlightResponse = new SearchFlightResponse();
        boolean isOneWayFlight = searchFlightRequest.getReturnTime() == null;

        List<FlightDto> departureFlights = flightService.findFlightsFilteredDay(
                searchFlightRequest.getDepartureAirportCityName(),
                searchFlightRequest.getArrivalAirportCityName(),
                searchFlightRequest.getDepartureTime());
        searchFlightResponse.setDepartureFlights(departureFlights);

        if(!isOneWayFlight){
            List<FlightDto> returnFlights = flightService.findFlightsFilteredDay(
                    searchFlightRequest.getArrivalAirportCityName(),
                    searchFlightRequest.getArrivalAirportCityName(),
                    searchFlightRequest.getReturnTime());
            searchFlightResponse.setReturnFlights(returnFlights);
        }
        return searchFlightResponse;
    }
}
