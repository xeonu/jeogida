package com.godofparking.jeogida.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteLocation {
    private Integer id;

    private Integer userId;

    private Integer locationId;
}
