package com.airbooking.bl.services;

import com.airbooking.bl.dto.FlightDto;
import com.airbooking.da.entities.Flight;
import com.airbooking.da.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends AbstractService<FlightDto, Flight, Long> {
    protected FlightService(@Autowired FlightRepository repository) {
        super(repository);
    }
}
