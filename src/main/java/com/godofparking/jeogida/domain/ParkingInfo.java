package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ParkingInfo {
    private Integer id;

    private String number;

    private Boolean isParked;

    private Date parkedAt;

    private Date leftAt;

    private Integer parkingLotId;
}
