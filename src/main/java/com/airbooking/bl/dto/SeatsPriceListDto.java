package com.airbooking.bl.dto;

public class SeatsPriceListDto {
    private int Id;

    private Long flightId;

    private double firstClassSeatPrice;

    private double businessClassSeatPrice;

    private double premiumEconomyClassSeatPrice;

    private double economyClassSeatPrice;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

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
