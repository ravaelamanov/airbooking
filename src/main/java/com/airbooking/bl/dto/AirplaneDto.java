package com.airbooking.bl.dto;

import java.util.List;

public class AirplaneDto {
    private Long Id;

    private String name;

    private AirplaneSeatsInfoDto airplaneSeatsInfoDto;

    private List<FlightDto> flights;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirplaneSeatsInfoDto getAirplaneSeatsInfoDto() {
        return airplaneSeatsInfoDto;
    }

    public void setAirplaneSeatsInfoDto(AirplaneSeatsInfoDto airplaneSeatsInfoDto) {
        this.airplaneSeatsInfoDto = airplaneSeatsInfoDto;
    }

    public List<FlightDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDto> flights) {
        this.flights = flights;
    }
}
