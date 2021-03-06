package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Car {
    private Integer id;

    private String number;

    private String name;

    private Integer user_id;
}
