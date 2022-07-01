package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteLocation {
    private Integer id;

    private Integer user_id;

    private Integer location_id;
}
