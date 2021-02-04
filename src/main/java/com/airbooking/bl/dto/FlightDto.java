package com.airbooking.bl.dto;

import java.time.LocalDateTime;
import java.util.List;

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

    public SeatsPriceListDto getSeatsPriceListDto() {
        return seatsPriceListDto;
    }

    public void setSeatsPriceListDto(SeatsPriceListDto seatsPriceListDto) {
        this.seatsPriceListDto = seatsPriceListDto;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public List<PassengerDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDto> passengers) {
        this.passengers = passengers;
    }
}
