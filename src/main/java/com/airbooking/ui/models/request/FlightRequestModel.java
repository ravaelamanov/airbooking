package com.airbooking.ui.models.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NotNull
public class FlightRequestModel {
    private String flightNo;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    @Size(min = 3, max = 3)
    private String departureAirport;

    @Size(min = 3, max = 3)
    private String arrivalAirport;

    private String departureCity;

    private String arrivalCity;

    private String airplaneName;

    @Valid
    private SeatsPriceListRequestModel seatsPriceListRequestModel;

    public SeatsPriceListRequestModel getSeatsPriceListRequestModel() {
        return seatsPriceListRequestModel;
    }

    public void setSeatsPriceListRequestModel(SeatsPriceListRequestModel seatsPriceListRequestModel) {
        this.seatsPriceListRequestModel = seatsPriceListRequestModel;
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

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }
}
