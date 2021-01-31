package com.airbooking.ui.models.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@NotNull
public class AirplaneRequestModel {
    private String name;

    @Valid
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
