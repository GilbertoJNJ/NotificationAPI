package com.gearsoftware.notificationapi.model.response;

public record ErrorDTO(
        int statusCode,
        String message
) {

}
