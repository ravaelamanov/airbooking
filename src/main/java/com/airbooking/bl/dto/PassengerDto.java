package com.airbooking.bl.dto;

import com.airbooking.da.util.SeatClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String passportNo;

    private int age;

    private String gender;

    private Long flightId;

    private SeatClass seatClass;
}
