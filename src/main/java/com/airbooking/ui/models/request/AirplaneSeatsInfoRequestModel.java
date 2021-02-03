package com.airbooking.ui.models.request;

import javax.validation.constraints.PositiveOrZero;

public class AirplaneSeatsInfoRequestModel {
    @PositiveOrZero
    private int firstClassSeatCount;

    @PositiveOrZero
    private int businessClassSeatCount;

    @PositiveOrZero
    private int premiumEconomyClassSeatCount;

    @PositiveOrZero
    private int economyClassSeatCount;

    public int getFirstClassSeatCount() {
        return firstClassSeatCount;
    }

    public void setFirstClassSeatCount(int firstClassSeatCount) {
        this.firstClassSeatCount = firstClassSeatCount;
    }

    public int getBusinessClassSeatCount() {
        return businessClassSeatCount;
    }

    public void setBusinessClassSeatCount(int businessClassSeatCount) {
        this.businessClassSeatCount = businessClassSeatCount;
    }

    public int getPremiumEconomyClassSeatCount() {
        return premiumEconomyClassSeatCount;
    }

    public void setPremiumEconomyClassSeatCount(int premiumEconomyClassSeatCount) {
        this.premiumEconomyClassSeatCount = premiumEconomyClassSeatCount;
    }

    public int getEconomyClassSeatCount() {
        return economyClassSeatCount;
    }

    public void setEconomyClassSeatCount(int economyClassSeatCount) {
        this.economyClassSeatCount = economyClassSeatCount;
    }
}
