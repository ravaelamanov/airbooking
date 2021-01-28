package com.airbooking.da.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "FLIGHTS")
public class Flight {
    @Id
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private Long Id;

    @Column(nullable = false, unique = true)
    private String flightNo;

    @Column(nullable = false)
    private LocalDateTime departureDateTime;

    @Column(nullable = false)
    private LocalDateTime arrivalDateTime;

    @Column(nullable = false)
    private String departureAirport;

    @Column(nullable = false)
    private String arrivalAirport;

    @Column(nullable = false)
    private String departureCity;

    @Column(nullable = false)
    private String arrivalCity;

    @ManyToOne
    private Airplane airplane;

    @OneToMany(mappedBy = "flight")
    private List<Passenger> passengers;

    @OneToOne(mappedBy = "flight")
    private SeatsPriceList seatsPriceList;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public SeatsPriceList getSeatsPriceList() {
        return seatsPriceList;
    }

    public void setSeatsPriceList(SeatsPriceList seatsPriceList) {
        this.seatsPriceList = seatsPriceList;
    }
}
