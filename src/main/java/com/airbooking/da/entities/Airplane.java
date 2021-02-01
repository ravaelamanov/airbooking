package com.airbooking.da.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

//FIXME revise airplane mapping

@Entity
@Table(name = "AIRPLANES")
public class Airplane {
    @Id
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private Long Id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private AirplaneSeatsInfo airplaneSeatsInfo;

    @OneToMany(mappedBy = "airplane", cascade = CascadeType.ALL)
    private List<Flight> flights;

    public List<Flight> getFlights() {
        return flights;
    }


    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirplaneSeatsInfo getAirplaneSeatsInfo() {
        return airplaneSeatsInfo;
    }

    public void setAirplaneSeatsInfo(AirplaneSeatsInfo airplaneSeatsInfo) {
        this.airplaneSeatsInfo = airplaneSeatsInfo;
        airplaneSeatsInfo.setAirplane(this);
    }
}
