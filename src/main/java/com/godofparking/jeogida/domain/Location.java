package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Location {
    private Integer id;

    private String name;

    private Integer total;

}
