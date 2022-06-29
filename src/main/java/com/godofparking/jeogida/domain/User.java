package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String email;

    private String nickname;

    private String password;

    private Date createdAt;

    private Date updatedAt;
}
