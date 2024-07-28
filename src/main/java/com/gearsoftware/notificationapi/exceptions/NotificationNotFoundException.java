package com.gearsoftware.notificationapi.exceptions;

import org.springframework.http.HttpStatus;

public final class NotificationNotFoundException extends HttpException {
    public NotificationNotFoundException() {
        super("Notificação não encontrada!", HttpStatus.NOT_FOUND);
    }
}
