package com.airbooking.ui.mappers;

import com.airbooking.bl.dto.AirplaneDto;
import com.airbooking.bl.dto.AirplaneSeatsInfoDto;
import com.airbooking.ui.models.request.AirplaneRequestModel;
import com.airbooking.ui.models.response.AirplaneResponseModel;
import com.airbooking.ui.models.response.AirplaneSeatsInfoResponseModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AirplaneMapperUI extends AbstractMapper<AirplaneResponseModel, AirplaneRequestModel, AirplaneDto>{
    @Override
    public AirplaneResponseModel toResponseModel(AirplaneDto airplaneDto) {
        return modelMapper.map(airplaneDto, AirplaneResponseModel.class);
    }

    @Override
    public AirplaneDto toDto(AirplaneRequestModel airplaneRequestModel) {
        return modelMapper.map(airplaneRequestModel, AirplaneDto.class);
    }

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(AirplaneDto.class, AirplaneResponseModel.class).
                addMappings(m -> m.skip(AirplaneResponseModel::setAirplaneSeatsInfoResponseModel)).
                setPostConverter(dtoResponseModelConverter());

        modelMapper.createTypeMap(AirplaneRequestModel.class, AirplaneDto.class).
                addMappings(m -> m.skip(AirplaneDto::setAirplaneSeatsInfoDto)).
                setPostConverter(requestModelDtoConverter());
    }

    @Override
    protected void dtoResponseModelCustomMapping(AirplaneDto airplaneDto, AirplaneResponseModel airplaneResponseModel) {
        airplaneResponseModel.setAirplaneSeatsInfoResponseModel(modelMapper.map(airplaneDto.getAirplaneSeatsInfoDto(), AirplaneSeatsInfoResponseModel.class));
    }

    @Override
    protected void requestModelDtoCustomMapping(AirplaneRequestModel airplaneRequestModel, AirplaneDto airplaneDto) {
        airplaneDto.setAirplaneSeatsInfoDto(modelMapper.map(airplaneRequestModel.getAirplaneSeatsInfoRequestModel(), AirplaneSeatsInfoDto.class));
    }
}
