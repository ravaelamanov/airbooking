package com.airbooking.bl.mappers;

import com.airbooking.bl.dto.AirplaneDto;
import com.airbooking.bl.dto.AirplaneSeatsInfoDto;
import com.airbooking.da.entities.Airplane;
import com.airbooking.da.entities.AirplaneSeatsInfo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(AirplaneDto.class, Airplane.class).
                addMappings(m -> m.skip(Airplane::setAirplaneSeatsInfo)).
                setPostConverter(dtoEntityConverter());

        modelMapper.createTypeMap(Airplane.class, AirplaneDto.class).
                addMappings(m -> m.skip(AirplaneDto::setAirplaneSeatsInfoDto)).
                setPostConverter(entityDtoConverter());

    }

    @Override
    protected void dtoEntityCustomMapping(AirplaneDto airplaneDto, Airplane airplane) {
        airplane.setAirplaneSeatsInfo(modelMapper.map(airplaneDto.getAirplaneSeatsInfoDto(), AirplaneSeatsInfo.class));
    }

    @Override
    protected void entityDtoCustomMapping(Airplane airplane, AirplaneDto airplaneDto) {
        airplaneDto.setAirplaneSeatsInfoDto(modelMapper.map(airplane.getAirplaneSeatsInfo(), AirplaneSeatsInfoDto.class));

    }
}
