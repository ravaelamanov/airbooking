package com.airbooking.bl.mappers;

import com.airbooking.bl.dto.PassengerDto;
import com.airbooking.da.entities.Passenger;
import com.airbooking.da.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PassengerMapper extends AbstractMapper<PassengerDto, Passenger> {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public PassengerDto toDto(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger toEntity(PassengerDto passengerDto) {
        return null;
    }

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(Passenger.class, PassengerDto.class).addMappings(m -> m.skip(PassengerDto::setFlightId)).setPostConverter(entityDtoConverter());
        modelMapper.createTypeMap(PassengerDto.class, Passenger.class).addMappings(m -> m.skip(Passenger::setFlight)).setPostConverter(dtoEntityConverter());
    }

    @Override
    protected void dtoEntityCustomMapping(PassengerDto passengerDto, Passenger passenger) {
        passenger.setFlight(flightRepository.findById(passengerDto.getFlightId()).orElse(null));
    }

    @Override
    protected void entityDtoCustomMapping(Passenger passenger, PassengerDto passengerDto) {
        passengerDto.setFlightId(passenger.getFlight().getId());
    }
}
