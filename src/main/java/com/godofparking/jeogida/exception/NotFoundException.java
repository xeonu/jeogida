package com.godofparking.jeogida.exception;

// 2xx -> ok
// 4xx -> client 오류
// 5xx -> server 오

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // 400번대 오류로 출력
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}