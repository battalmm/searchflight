package com.amadeus.yusufcankorkmaz.casestudy.searchflight.mockapi;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.CreateFlightRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MockedFlightsData {
    public List<CreateFlightRequest> fetchMockedFlightsData(){
        List<CreateFlightRequest> mockedFlights = new ArrayList<>();

        LocalDateTime time = LocalDateTime.now();
        Double price = 100D;

        for (int count = 0; count < 20; count++){
            CreateFlightRequest mockedFlight = new CreateFlightRequest(
                    1L + count,
                    2L + count,
                    price,
                    time.plusHours(1L),
                    time
            );
            mockedFlights.add(mockedFlight);
        }

        return  mockedFlights;
    }
}
