package com.airbooking.ui.controllers;

import com.airbooking.bl.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void getFlights() {

    }

    @GetMapping(path = "/{flightId}")
    @ResponseStatus(HttpStatus.OK)
    public void getFlight(@PathVariable Long flightId) {

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
