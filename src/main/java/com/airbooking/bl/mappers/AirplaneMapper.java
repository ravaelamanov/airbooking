package com.airbooking.bl.mappers;

import com.airbooking.bl.dto.AirplaneDto;
import com.airbooking.da.entities.Airplane;
import org.springframework.stereotype.Component;

@Component
public class AirplaneMapper extends AbstractMapper<AirplaneDto, Airplane>{
    @Override
    public AirplaneDto toDto(Airplane airplane) {
        return modelMapper.map(airplane, AirplaneDto.class);
    }

    @Override
    public Airplane toEntity(AirplaneDto airplaneDto) {
        return modelMapper.map(airplaneDto, Airplane.class);
    }
}
