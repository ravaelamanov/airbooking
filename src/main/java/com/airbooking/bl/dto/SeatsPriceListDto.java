package com.airbooking.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatsPriceListDto {
    private int Id;

    private Long flightId;

    private double firstClassSeatPrice;

    private double businessClassSeatPrice;

    private double premiumEconomyClassSeatPrice;

    private double economyClassSeatPrice;
}
