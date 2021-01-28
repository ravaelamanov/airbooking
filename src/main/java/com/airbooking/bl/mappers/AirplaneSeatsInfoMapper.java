package com.airbooking.bl.mappers;

import com.airbooking.bl.dto.AirplaneSeatsInfoDto;
import com.airbooking.da.entities.AirplaneSeatsInfo;
import com.airbooking.da.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AirplaneSeatsInfoMapper extends AbstractMapper<AirplaneSeatsInfoDto, AirplaneSeatsInfo> {
    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public AirplaneSeatsInfoDto toDto(AirplaneSeatsInfo airplaneSeatsInfo) {
        return modelMapper.map(airplaneSeatsInfo, AirplaneSeatsInfoDto.class);
    }

    @Override
    public AirplaneSeatsInfo toEntity(AirplaneSeatsInfoDto airplaneSeatsInfoDto) {
        return modelMapper.map(airplaneSeatsInfoDto, AirplaneSeatsInfo.class);
    }

    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(AirplaneSeatsInfo.class, AirplaneSeatsInfoDto.class).addMappings(m -> m.skip(AirplaneSeatsInfoDto::setAirplaneId)).setPostConverter(entityDtoConverter());
        modelMapper.createTypeMap(AirplaneSeatsInfoDto.class, AirplaneSeatsInfo.class).addMappings(m -> m.skip(AirplaneSeatsInfo::setAirplane)).setPostConverter(dtoEntityConverter());
    }

    @Override
    protected void dtoEntityCustomMapping(AirplaneSeatsInfoDto airplaneSeatsInfoDto, AirplaneSeatsInfo airplaneSeatsInfo) {
        airplaneSeatsInfo.setAirplane(airplaneRepository.findById(airplaneSeatsInfoDto.getAirplaneId()).orElse(null));
    }

    @Override
    protected void entityDtoCustomMapping(AirplaneSeatsInfo airplaneSeatsInfo, AirplaneSeatsInfoDto airplaneSeatsInfoDto) {
        airplaneSeatsInfoDto.setAirplaneId(airplaneSeatsInfo.getAirplane().getId());
    }
}
