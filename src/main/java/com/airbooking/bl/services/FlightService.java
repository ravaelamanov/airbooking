package com.airbooking.bl.services;

import com.airbooking.bl.dto.FlightDto;
import com.airbooking.bl.dto.PassengerDto;
import com.airbooking.bl.mappers.IMapper;
import com.airbooking.da.entities.Flight;
import com.airbooking.da.entities.Passenger;
import com.airbooking.da.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends AbstractService<FlightDto, Flight, Long> {
    @Autowired
    IMapper<PassengerDto, Passenger> pMapper;

    protected FlightService(@Autowired FlightRepository repository) {
        super(repository);
    }

    public Iterable<FlightDto> findBetweenCities(String from, String to) {
        Iterable<Flight> result = ((FlightRepository) repository).findByDepartureCityAndArrivalCity(from, to);
        return modelMapper.toDto(result);
    }

    public FlightDto addPassenger(Long flightId, PassengerDto passengerDto) {
        FlightDto flightDto = findById(flightId);
        flightDto.addPassenger(passengerDto);
        return update(flightDto);
    }

    public Iterable<PassengerDto> findAllPassengers(Long flightId) {
        return findById(flightId).getPassengers();
    }
}
