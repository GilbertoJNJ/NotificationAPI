package com.gearsoftware.notificationapi.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
sealed public class HttpException extends RuntimeException
        permits NotificationNotFoundException {

    private HttpStatus httpStatus;

    public HttpException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
