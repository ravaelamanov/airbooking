package com.airbooking.bl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long Id;

    private String flightNo;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private String departureAirport;

    private String arrivalAirport;

    private String departureCity;

    private String arrivalCity;

    private Long airplaneId;

    private List<PassengerDto> passengers;

    private SeatsPriceListDto seatsPriceListDto;

    public void addPassenger(PassengerDto passengerDto) {
        passengers.add(passengerDto);
        passengerDto.setFlightId(Id);
    }
}
