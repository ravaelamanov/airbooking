package com.airbooking.bl.dto;

public class AirplaneSeatsInfoDto {
    private Long Id;

    private Long airplaneId;

    private int firstClassSeatCount;

    private int businessClassSeatCount;

    private int premiumEconomyClassSeatCount;

    private int economyClassSeatCount;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Long airplaneId) {
        this.airplaneId = airplaneId;
    }

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
