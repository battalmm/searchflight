package com.amadeus.yusufcankorkmaz.casestudy.searchflight.controller;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.CreateFlightRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.FlightDto;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            description = "Get all available flights information",
            summary = "Get all flights"
    )
    public List<FlightDto> getAllFlights(){
        return  flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            description = "Get a flight information with related id",
            summary = "Get flight"
    )
    public FlightDto getFlightWithId(@PathVariable Long id){
        return flightService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            description = "Create a new flight with given information.",
            summary = "Create new flight")
    public FlightDto createFlight(@RequestBody CreateFlightRequest createFlightRequest){
        return flightService.createFlight(createFlightRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            description = "Update an flight information with related id.",
            summary = "Update flight"
    )
    public FlightDto updateFlight(@PathVariable Long id, @RequestBody FlightDto flightDto){
        return flightService.updateFlight(id, flightDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            description = "Delete a flight with given id.",
            summary = "Delete flight"
    )
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
    }

}
