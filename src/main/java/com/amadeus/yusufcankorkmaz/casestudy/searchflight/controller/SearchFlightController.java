package com.amadeus.yusufcankorkmaz.casestudy.searchflight.controller;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.SearchFlightRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.SearchFlightResponse;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.SearchFlightService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/search")
public class SearchFlightController {

    private final SearchFlightService searchFlightService;

    public SearchFlightController(SearchFlightService searchFlightService) {
        this.searchFlightService = searchFlightService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            description = "Returns flights with filtered time and location. There might be two different choices " +
                    "One way flight if user enter just departure time, " +
                    "Round trip if user enter both departure time and return time.",
            summary = "Get flights with filtered search"
    )
    public SearchFlightResponse searchFlight(@RequestBody SearchFlightRequest searchFlightRequest){
        return searchFlightService.searchFlights(searchFlightRequest);
    }
}
