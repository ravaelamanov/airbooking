package com.airbooking.ui.models.response;

import com.airbooking.bl.dto.AirplaneSeatsInfoDto;

public class AirplaneResponseModel {
    private String name;

    private AirplaneSeatsInfoDto airplaneSeatsInfoDto;

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
}
