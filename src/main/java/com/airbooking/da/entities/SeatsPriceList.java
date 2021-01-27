package com.airbooking.da.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEATSPRICELIST")
public class SeatsPriceList {
    @Id
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int Id;

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
