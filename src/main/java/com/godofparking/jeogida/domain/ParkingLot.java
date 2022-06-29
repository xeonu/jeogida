package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ParkingLot {
    private Integer id;

    private Integer number;

    private Date createdAt;

    private Date updatedAt;

    private Integer locationId;

    private Integer mapId;
}
