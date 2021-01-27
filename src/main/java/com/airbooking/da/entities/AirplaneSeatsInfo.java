package com.airbooking.da.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "AirplaneSeatsInfo")
public class AirplaneSeatsInfo {

    @Id
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private Long Id;

    @OneToOne
    private Airplane airplane;

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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}
