package com.airbooking.bl.mappers;

import com.airbooking.bl.dto.SeatsPriceListDto;
import com.airbooking.da.entities.SeatsPriceList;
import com.airbooking.da.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeatsPriceListMapper extends AbstractMapper<SeatsPriceListDto, SeatsPriceList> {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public SeatsPriceListDto toDto(SeatsPriceList seatsPriceList) {
        return modelMapper.map(seatsPriceList, SeatsPriceListDto.class);
    }

    @Override
    public SeatsPriceList toEntity(SeatsPriceListDto seatsPriceListDto) {
        return modelMapper.map(seatsPriceListDto, SeatsPriceList.class);
    }

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(SeatsPriceList.class, SeatsPriceListDto.class).addMappings(m -> m.skip(SeatsPriceListDto::setFlightId)).setPostConverter(entityDtoConverter());
        modelMapper.createTypeMap(SeatsPriceListDto.class, SeatsPriceList.class).addMappings(m -> m.skip(SeatsPriceList::setFlight)).setPostConverter(dtoEntityConverter());
    }

    @Override
    protected void dtoEntityCustomMapping(SeatsPriceListDto seatsPriceListDto, SeatsPriceList seatsPriceList) {
        seatsPriceList.setFlight(flightRepository.findById(seatsPriceListDto.getFlightId()).orElse(null));
    }

    @Override
    protected void entityDtoCustomMapping(SeatsPriceList seatsPriceList, SeatsPriceListDto seatsPriceListDto) {
        seatsPriceListDto.setFlightId(seatsPriceList.getFlight().getId());
    }
}
