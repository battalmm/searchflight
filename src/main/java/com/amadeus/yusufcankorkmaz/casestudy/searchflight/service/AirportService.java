package com.amadeus.yusufcankorkmaz.casestudy.searchflight.service;

import com.amadeus.yusufcankorkmaz.casestudy.searchflight.dto.AirportDto;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.entity.Airport;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.exception.ExceptionEntity;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.exception.NotFoundException;
import com.amadeus.yusufcankorkmaz.casestudy.searchflight.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public AirportDto getAirportById(Long id){
        Airport airport = airportRepository.findById(id).orElseThrow(()-> new NotFoundException(ExceptionEntity.Airport));
        return AirportDto.airportToDto(airport);
    }

    public List<AirportDto> getAllAirports(){
        List<Airport> airports = airportRepository.findAll();
        return airports
                .stream()
                .map(AirportDto::airportToDto)
                .collect(Collectors.toList());
    }

    public AirportDto getAirportByCityName(String cityName){
        Airport airport = airportRepository.getAirportByCityName(cityName).orElseThrow(()-> new NotFoundException(ExceptionEntity.Airport));
        return AirportDto.airportToDto(airport);
    }

    public AirportDto createAirport(AirportDto airportDto){
        Airport newAirport = new Airport(airportDto.getCityName());
        return AirportDto.airportToDto(airportRepository.save(newAirport));
    }

    public AirportDto updateAirport(Long id,AirportDto airportDto){
        Airport airport = airportRepository.findById(id).orElseThrow(()-> new NotFoundException(ExceptionEntity.Airport));
        airport.setCityName(airport.getCityName());
        return AirportDto.airportToDto(airportRepository.save(airport));
    }

    public void deleteAirport(Long id){
        boolean isAirportExist = airportRepository.existsById(id);
        if(!isAirportExist){
            throw new NotFoundException(ExceptionEntity.Airport);
        }
        airportRepository.deleteById(id);
    }

    protected Airport fetchAirportById(Long id){
        return airportRepository.findById(id).orElseThrow( () -> new NotFoundException(ExceptionEntity.Airport));
    }
}
