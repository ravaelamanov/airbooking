package com.airbooking.da.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "AirplaneSeatsInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneSeatsInfo {

    @Id
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private Long Id;

    @OneToOne(mappedBy = "airplaneSeatsInfo", optional = false)
    private Airplane airplane;

    private int firstClassSeatCount;

    private int businessClassSeatCount;

    private int premiumEconomyClassSeatCount;

    private int economyClassSeatCount;
}
