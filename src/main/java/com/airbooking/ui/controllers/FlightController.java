package com.airbooking.ui.controllers;

import com.airbooking.bl.services.AirplaneService;
import com.airbooking.bl.services.FlightService;
import com.airbooking.ui.models.response.FlightResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FlightResponseModel> getFlights() {
        List<FlightResponseModel> responseModels = new ArrayList<>();
        flightService.findAll().forEach(flightDto -> {responseModels.add(modelMapper.map(flightDto, FlightResponseModel.class));});
        return responseModels;

    }

    @GetMapping(path = "/{flightId}")
    @ResponseStatus(HttpStatus.OK)
    public FlightResponseModel getFlight(@PathVariable Long flightId) {
        return modelMapper.map(flightService.findById(flightId), FlightResponseModel.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFlight() {

    }

    @PutMapping(path = "/{flightId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFlight(@PathVariable Long flightId) {

    }

    @DeleteMapping(path = "/{flightId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long flightId) {
    }
}
