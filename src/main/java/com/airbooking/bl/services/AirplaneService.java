package com.airbooking.bl.services;

import com.airbooking.bl.dto.AirplaneDto;
import com.airbooking.da.entities.Airplane;
import com.airbooking.da.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService extends AbstractService<AirplaneDto, Airplane, Long> {
    protected AirplaneService(@Autowired AirplaneRepository repository) {
        super(repository);
    }
}
