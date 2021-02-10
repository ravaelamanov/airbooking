package com.airbooking.da.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AIRPLANES")
@Getter
@Setter
@NoArgsConstructor
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

    public void setAirplaneSeatsInfo(AirplaneSeatsInfo airplaneSeatsInfo) {
        this.airplaneSeatsInfo = airplaneSeatsInfo;
        airplaneSeatsInfo.setAirplane(this);
    }
}
