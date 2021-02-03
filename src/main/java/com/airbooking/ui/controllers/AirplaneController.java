 package com.airbooking.ui.controllers;

import com.airbooking.bl.dto.AirplaneDto;
import com.airbooking.bl.services.AirplaneService;
import com.airbooking.ui.mappers.IMapper;
import com.airbooking.ui.models.request.AirplaneRequestModel;
import com.airbooking.ui.models.response.AirplaneResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("airplanes")
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private IMapper<AirplaneResponseModel, AirplaneRequestModel, AirplaneDto> modelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<AirplaneResponseModel> getAirplanes() {
        return modelMapper.toResponseModel(airplaneService.findAll());

    }

    @GetMapping(path = "/{airplaneId}")
    @ResponseStatus(HttpStatus.OK)
    public AirplaneResponseModel getAirplane(@PathVariable Long airplaneId) {
        return modelMapper.toResponseModel(airplaneService.findById(airplaneId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirplaneResponseModel createAirplane(@RequestBody @Valid AirplaneRequestModel airplaneRequestModel) {
        return modelMapper.toResponseModel(airplaneService.create(modelMapper.toDto(airplaneRequestModel)));
    }

    @PutMapping(path = "/{airplaneId}")
    @ResponseStatus(HttpStatus.OK)
    public AirplaneResponseModel updateAirplane(@PathVariable Long airplaneId,
                                                @RequestBody @Valid AirplaneRequestModel airplaneRequestModel) {
        AirplaneDto airplaneDto = modelMapper.toDto(airplaneRequestModel);
        airplaneDto.setId(airplaneId);
        return modelMapper.toResponseModel(airplaneService.update(airplaneDto));
    }

    @DeleteMapping(path = "/{airplaneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long airplaneId) {
        airplaneService.deleteById(airplaneId);
    }

}
