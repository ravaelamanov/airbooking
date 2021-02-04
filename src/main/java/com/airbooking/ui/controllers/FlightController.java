package com.airbooking.ui.controllers;

import com.airbooking.bl.dto.FlightDto;
import com.airbooking.bl.dto.PassengerDto;
import com.airbooking.bl.services.FlightService;
import com.airbooking.ui.mappers.IMapper;
import com.airbooking.ui.models.request.FlightBetweenCitiesRequestModel;
import com.airbooking.ui.models.request.FlightRequestModel;
import com.airbooking.ui.models.request.PassengerRequestModel;
import com.airbooking.ui.models.response.FlightResponseModel;
import com.airbooking.ui.models.response.PassengerResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private IMapper<FlightResponseModel, FlightRequestModel, FlightDto> modelMapper;

    @Autowired
    private IMapper<PassengerResponseModel, PassengerRequestModel, PassengerDto> passengerMapper;

    /*@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<FlightResponseModel> getFlights() {
        return modelMapper.toResponseModel(flightService.findAll());
    }*/

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<FlightResponseModel> getFlights(@RequestBody @Valid FlightBetweenCitiesRequestModel flightBetweenCitiesRequestModel) {
        return modelMapper.toResponseModel(flightService.findBetweenCities(flightBetweenCitiesRequestModel.getFrom(), flightBetweenCitiesRequestModel.getTo())); 
    }

    @GetMapping(path = "/{flightId}")
    @ResponseStatus(HttpStatus.OK)
    public FlightResponseModel getFlight(@PathVariable Long flightId) {
        return modelMapper.toResponseModel(flightService.findById(flightId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlightResponseModel createFlight(@RequestBody @Valid FlightRequestModel flightRequestModel) {
       return modelMapper.toResponseModel(flightService.create(modelMapper.toDto(flightRequestModel)));
    }

    @PutMapping(path = "/{flightId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFlight(@PathVariable Long flightId,
                             @RequestBody @Valid FlightRequestModel flightRequestModel) {
        FlightDto flightDto = modelMapper.toDto(flightRequestModel);
        flightDto.setId(flightId);
        flightService.update(flightDto);
        //TODO think about update request model
    }

    @DeleteMapping(path = "/{flightId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long flightId) {
        flightService.deleteById(flightId);
    }

    @GetMapping(path = "/{flightId}/passengers")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<PassengerResponseModel> getPassengers(@PathVariable Long flightId) {
        return passengerMapper.toResponseModel(flightService.findAllPassengers(flightId));
    }


    @PutMapping(path = "/{flightId}/passengers")
    @ResponseStatus(HttpStatus.OK)
    public FlightResponseModel addPassenger(@PathVariable Long flightId,
                                            @RequestBody @Valid PassengerRequestModel passengerRequestModel) {
        FlightDto flightDto = flightService.addPassenger(flightId, passengerMapper.toDto(passengerRequestModel));
        return modelMapper.toResponseModel(flightDto);
    }
}
