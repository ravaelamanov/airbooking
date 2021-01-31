package com.airbooking.ui.models.response;

public class AirplaneResponseModel {
    private String name;

    private AirplaneSeatsInfoResponseModel airplaneSeatsInfoResponseModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirplaneSeatsInfoResponseModel getAirplaneSeatsInfoResponseModel() {
        return airplaneSeatsInfoResponseModel;
    }

    public void setAirplaneSeatsInfoResponseModel(AirplaneSeatsInfoResponseModel airplaneSeatsInfoResponseModel) {
        this.airplaneSeatsInfoResponseModel = airplaneSeatsInfoResponseModel;
    }
}
