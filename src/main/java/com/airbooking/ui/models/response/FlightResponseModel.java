package com.airbooking.ui.models.response;

import java.time.LocalDateTime;

//TODO:
// - create request model => dto, dto => response model mappers
// - create airplane controller

public class FlightResponseModel {
    private String flightNo;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private String departureAirport;

    private String arrivalAirport;

    private String departureCity;

    private String arrivalCity;

    private AirplaneResponseModel airplaneResponseModel;

    private SeatsPriceListResponseModel seatsPriceListResponseModel;

    public SeatsPriceListResponseModel getSeatsPriceListResponseModel() {
        return seatsPriceListResponseModel;
    }

    public void setSeatsPriceListResponseModel(SeatsPriceListResponseModel seatsPriceListResponseModel) {
        this.seatsPriceListResponseModel = seatsPriceListResponseModel;
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

    public AirplaneResponseModel getAirplaneResponseModel() {
        return airplaneResponseModel;
    }

    public void setAirplaneResponseModel(AirplaneResponseModel airplaneResponseModel) {
        this.airplaneResponseModel = airplaneResponseModel;
    }
}
