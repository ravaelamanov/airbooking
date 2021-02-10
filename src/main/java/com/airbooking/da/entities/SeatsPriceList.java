package com.airbooking.da.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SeatsPriceList")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatsPriceList {
    @Id
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int Id;

    @OneToOne(mappedBy = "seatsPriceList")
    private Flight flight;

    private double firstClassSeatPrice;

    private double businessClassSeatPrice;

    private double premiumEconomyClassSeatPrice;

    private double economyClassSeatPrice;
}
