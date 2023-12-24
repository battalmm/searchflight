package com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.scheduled;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.CreateFlightRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.mockapi.MockedFlightsData;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.FlightService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchFlightsData {

    private final FlightService flightService;
    private final MockedFlightsData mockedFlightsData;

    public FetchFlightsData(FlightService flightService,
                            MockedFlightsData mockedFlightsData) {
        this.flightService = flightService;
        this.mockedFlightsData = mockedFlightsData;
    }

    @Scheduled(cron = "0/30 * * * * *")
    public void fetchFlightsData(){
        List<CreateFlightRequest> mockedFlights = mockedFlightsData.fetchMockedFlightsData();
        flightService.createFlightWithList(mockedFlights);
    }
}
