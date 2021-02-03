package com.airbooking.ui.models.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//FIXME validation not working

public class AirplaneRequestModel {
    @NotEmpty
    private String name;

    @NotNull
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
