package com.airbooking.ui.models.request;

public class SeatsPriceListRequestModel {
    private double firstClassSeatPrice;

    private double businessClassSeatPrice;

    private double premiumEconomyClassSeatPrice;

    private double economyClassSeatPrice;

    public double getFirstClassSeatPrice() {
        return firstClassSeatPrice;
    }

    public void setFirstClassSeatPrice(double firstClassSeatPrice) {
        this.firstClassSeatPrice = firstClassSeatPrice;
    }

    public double getBusinessClassSeatPrice() {
        return businessClassSeatPrice;
    }

    public void setBusinessClassSeatPrice(double businessClassSeatPrice) {
        this.businessClassSeatPrice = businessClassSeatPrice;
    }

    public double getPremiumEconomyClassSeatPrice() {
        return premiumEconomyClassSeatPrice;
    }

    public void setPremiumEconomyClassSeatPrice(double premiumEconomyClassSeatPrice) {
        this.premiumEconomyClassSeatPrice = premiumEconomyClassSeatPrice;
    }

    public double getEconomyClassSeatPrice() {
        return economyClassSeatPrice;
    }

    public void setEconomyClassSeatPrice(double economyClassSeatPrice) {
        this.economyClassSeatPrice = economyClassSeatPrice;
    }
}
