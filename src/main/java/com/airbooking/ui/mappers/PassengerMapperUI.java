package com.airbooking.ui.mappers;

import com.airbooking.bl.dto.PassengerDto;
import com.airbooking.ui.models.request.PassengerRequestModel;
import com.airbooking.ui.models.response.PassengerResponseModel;

import org.springframework.stereotype.Component;

@Component
public class PassengerMapperUI extends AbstractMapper<PassengerResponseModel, PassengerRequestModel, PassengerDto> {

    @Override
    public PassengerResponseModel toResponseModel(PassengerDto dto) {
        return modelMapper.map(dto, PassengerResponseModel.class);
    }

    @Override
    public PassengerDto toDto(PassengerRequestModel requestModel) {
        return modelMapper.map(requestModel, PassengerDto.class);
    }
    
}
