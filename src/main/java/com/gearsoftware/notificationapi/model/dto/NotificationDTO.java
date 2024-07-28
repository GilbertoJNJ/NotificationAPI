package com.gearsoftware.notificationapi.model.dto;

import com.gearsoftware.notificationapi.model.enums.Priority;
import com.gearsoftware.notificationapi.model.enums.Type;

import java.time.LocalDateTime;

public record NotificationDTO(
        Long id,
        String title,
        String message,
        Type type,
        LocalDateTime createdAt,
        Boolean read,
        LocalDateTime readAt,
        Priority priority,
        String link
) {
}
