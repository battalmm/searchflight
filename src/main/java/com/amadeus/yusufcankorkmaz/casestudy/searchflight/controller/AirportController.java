package com.amadeus.yusufcankorkmaz.casestudy.searchflight.controller;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.AirportDto;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.service.AirportService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airport")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            description = "Get an airport with its id.",
            summary = "Get airport"
    )
    public AirportDto getAirportById(@PathVariable Long id){
        return airportService.getAirportById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            description = "Get all airports inside list.",
            summary = "Get all airports"
    )
    public List<AirportDto> getAllAirports(){
        return airportService.getAllAirports();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            description = "Create a new airport with given data.",
            summary = "Create new airport")
    public AirportDto createAirport(@RequestBody AirportDto airportDto){
        return airportService.createAirport(airportDto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            description = "Update an airport with given id.",
            summary = "Update airport"
    )
    public AirportDto updateAirport(@PathVariable Long id, @RequestBody AirportDto airportDto){
        return airportService.updateAirport(id, airportDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            description = "Delete an airport with given id.",
            summary = "Delete airport"
    )
    public void deleteAirport(@PathVariable Long id){
        airportService.deleteAirport(id);
    }
}
