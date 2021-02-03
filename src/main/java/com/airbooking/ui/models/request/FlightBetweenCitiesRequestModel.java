package com.airbooking.ui.models.request;

import javax.validation.constraints.NotEmpty;

public class FlightBetweenCitiesRequestModel {
    @NotEmpty
    private String from;

    @NotEmpty
    private String to;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
    
}
