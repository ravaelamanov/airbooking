package com.airbooking.da.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "FLIGHTS")
public class Flight {
    @Id
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private Long ID;

    @Column(nullable = false, unique = true)
    private String FlightNo;

    @Column(nullable = false)
    private LocalDateTime departureDateTime;

    @Column(nullable = false)
    private LocalDateTime arrivalDateTime;

    @Column(nullable = false)
    private String departureAirport;

    @Column(nullable = false)
    private String arrivalAirport;

    @Column(nullable = false)
    private String departureCountry;

    @Column(nullable = false)
    private String arrivalCountry;

    @Column(nullable = false)
    private Airplane airplane;


}
