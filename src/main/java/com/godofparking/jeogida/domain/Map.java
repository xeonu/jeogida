package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Data
@AllArgsConstructor
public class Map {
    private Integer id;

    private String name;

    private String path;

    private Date createdAt;

    private Date updatedAt;
}
