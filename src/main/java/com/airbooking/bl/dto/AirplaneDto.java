package com.airbooking.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDto {
    private Long Id;

    private String name;

    private AirplaneSeatsInfoDto airplaneSeatsInfoDto;

    private List<FlightDto> flights;
}
