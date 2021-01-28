package com.airbooking.bl.services;

import com.airbooking.bl.dto.PassengerDto;
import com.airbooking.da.entities.Passenger;
import com.airbooking.da.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService extends AbstractService<PassengerDto, Passenger, Long> {
    protected PassengerService(@Autowired PassengerRepository repository) {
        super(repository);
    }
}
