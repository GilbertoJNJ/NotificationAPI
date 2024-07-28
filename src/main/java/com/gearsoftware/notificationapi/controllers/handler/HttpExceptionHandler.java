package com.gearsoftware.notificationapi.controllers.handler;

import com.gearsoftware.notificationapi.exceptions.HttpException;
import com.gearsoftware.notificationapi.model.response.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HttpExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ErrorDTO> handlerHttpException(HttpException exception) {
        return ResponseEntity.status(exception.getHttpStatus())
                .body(new ErrorDTO(exception.getHttpStatus().value(), exception.getMessage()));
    }
}
