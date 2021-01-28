package com.airbooking.bl.mappers;

import com.airbooking.bl.dto.FlightDto;
import com.airbooking.da.entities.Flight;
import com.airbooking.da.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class FlightMapper extends AbstractMapper<FlightDto, Flight> {
    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public FlightDto toDto(Flight flight) {
        return modelMapper.map(flight, FlightDto.class);
    }

    @Override
    public Flight toEntity(FlightDto flightDto) {
        return modelMapper.map(flightDto, Flight.class);
    }

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(Flight.class, FlightDto.class).addMappings(m -> {m.skip(FlightDto::setAirplaneId);}).setPostConverter(entityDtoConverter());
        modelMapper.createTypeMap(FlightDto.class, Flight.class).addMappings(m -> {m.skip(Flight::setAirplane);}).setPostConverter(dtoEntityConverter());
    }

    @Override
    protected void dtoEntityCustomMapping(FlightDto flightDto, Flight flight) {
        flight.setAirplane(airplaneRepository.findById(flightDto.getAirplaneId()).orElse(null));
    }

    @Override
    protected void entityDtoCustomMapping(Flight flight, FlightDto flightDto) {
        flightDto.setAirplaneId(flight.getAirplane().getId());
    }
}
