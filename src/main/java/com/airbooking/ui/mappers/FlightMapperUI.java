package com.airbooking.ui.mappers;

import com.airbooking.bl.dto.FlightDto;
import com.airbooking.bl.dto.SeatsPriceListDto;
import com.airbooking.bl.services.AirplaneService;
import com.airbooking.ui.models.request.FlightRequestModel;
import com.airbooking.ui.models.response.AirplaneResponseModel;
import com.airbooking.ui.models.response.FlightResponseModel;
import com.airbooking.ui.models.response.SeatsPriceListResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FlightMapperUI extends AbstractMapper<FlightResponseModel, FlightRequestModel, FlightDto> {
    @Autowired
    private AirplaneService airplaneService;

    @Override
    public FlightResponseModel toResponseModel(FlightDto flightDto) {
        return modelMapper.map(flightDto, FlightResponseModel.class);
    }

    @Override
    public FlightDto toDto(FlightRequestModel flightRequestModel) {
        return modelMapper.map(flightRequestModel, FlightDto.class);
    }

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(FlightDto.class, FlightResponseModel.class).
                addMappings(m -> m.skip(FlightResponseModel::setAirplaneResponseModel)).
                addMappings(m -> m.skip(FlightResponseModel::setSeatsPriceListResponseModel)).
                setPostConverter(dtoResponseModelConverter());

        modelMapper.createTypeMap(FlightRequestModel.class, FlightDto.class).
                addMappings(m -> m.skip(FlightDto::setAirplaneId)).
                addMappings(m -> m.skip(FlightDto::setSeatsPriceListDto)).
                setPostConverter(requestModelDtoConverter());
    }

    @Override
    protected void dtoResponseModelCustomMapping(FlightDto flightDto, FlightResponseModel flightResponseModel) {
        flightResponseModel.setAirplaneResponseModel(modelMapper.map(airplaneService.findById(flightDto.getAirplaneId()), AirplaneResponseModel.class));
        flightResponseModel.setSeatsPriceListResponseModel(modelMapper.map(flightDto.getSeatsPriceListDto(), SeatsPriceListResponseModel.class));
    }

    @Override
    protected void requestModelDtoCustomMapping(FlightRequestModel flightRequestModel, FlightDto flightDto) {
        flightDto.setAirplaneId(airplaneService.findByName(flightRequestModel.getAirplaneName()).getId());
        flightDto.setSeatsPriceListDto(modelMapper.map(flightRequestModel.getSeatsPriceListRequestModel(), SeatsPriceListDto.class));
    }
}
