package com.airbooking.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneSeatsInfoDto {
    private Long Id;

    private Long airplaneId;

    private int firstClassSeatCount;

    private int businessClassSeatCount;

    private int premiumEconomyClassSeatCount;

    private int economyClassSeatCount;
}
