package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Integer id;

    private String nickname;

    private String password;

    private Date createdAt;

    private Date updatedAt;
}
