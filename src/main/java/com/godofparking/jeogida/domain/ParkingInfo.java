package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ParkingInfo {
    private Integer id;

    private String number;

    private Boolean is_parked; // 0: 비어있음 1: 주차됨

    private Integer parking_lot_id;
}
