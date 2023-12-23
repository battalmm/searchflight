package com.amadeus.yusufcankorkmaz.casestudy.searchflight.service;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.CreateFlightRequest;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.FlightDto;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Flight;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.exception.ExceptionEntity;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.exception.NotFoundException;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirportService airportService;

    public FlightService(FlightRepository flightRepository,
                         AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }

    public FlightDto findById(Long id){
        Flight flight = flightRepository.findById(id)
                .orElseThrow(()->new NotFoundException(ExceptionEntity.Flight));
        return FlightDto.convertFlightToDto(flight);
    }

    public List<FlightDto> getAllFlights(){
        List<Flight> fligthList = flightRepository.findAll();
        return fligthList
                .stream()
                .map(FlightDto::convertFlightToDto)
                .collect(Collectors.toList());
    }

    public FlightDto createFlight(CreateFlightRequest request){
        Flight flight = new Flight(
                request.getDepartureDate(),
                request.getArrivalDate(),
                request.getPrice(),
                airportService.fetchAirportById(request.getDepartureAirportId()),
                airportService.fetchAirportById(request.getArrivalAirportId())
        );
        return FlightDto.convertFlightToDto(flight);
    }

    public FlightDto updateFlight(Long id, FlightDto newFlightData){
        Flight flight = flightRepository.findById(id).orElseThrow(()-> new NotFoundException(ExceptionEntity.Flight));
        flight.setArrivalAirport(airportService.fetchAirportById(newFlightData.getArrivalAirportId()));
        flight.setDepartureAirport(airportService.fetchAirportById(newFlightData.getDepartureAirportId()));
        flight.setPrice(newFlightData.getPrice());
        flight.setArrivalTime(newFlightData.getArrivalTime());
        flight.setDepartureTime(newFlightData.getDepartureTime());
        return FlightDto.convertFlightToDto(flightRepository.save(flight));
    }

    // Complete
    public void deleteFlight(Long flightId){
        boolean isFlightExist = flightRepository.existsById(flightId);
        if(!isFlightExist){
            throw new NotFoundException(ExceptionEntity.Flight);
        }
        flightRepository.deleteById(flightId);
    }


}
