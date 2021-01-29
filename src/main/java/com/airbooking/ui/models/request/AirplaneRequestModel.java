package com.airbooking.ui.models.request;

import com.airbooking.bl.dto.AirplaneSeatsInfoDto;

public class AirplaneRequestModel {
    private String name;

    private AirplaneSeatsInfoRequestModel airplaneSeatsInfoRequestModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirplaneSeatsInfoRequestModel getAirplaneSeatsInfoRequestModel() {
        return airplaneSeatsInfoRequestModel;
    }

    public void setAirplaneSeatsInfoRequestModel(AirplaneSeatsInfoRequestModel airplaneSeatsInfoRequestModel) {
        this.airplaneSeatsInfoRequestModel = airplaneSeatsInfoRequestModel;
    }
}
