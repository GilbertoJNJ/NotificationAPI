package com.gearsoftware.notificationapi.services;

import com.gearsoftware.notificationapi.model.dto.NotificationDTO;
import org.springframework.data.domain.Page;

public interface INotificationService {

    NotificationDTO create();

    Page<NotificationDTO> findAll(String userId);

    NotificationDTO findById(String userId, Long id);

    void deleteById(String userId, Long id);

    void markAsRead(String userId, Long id);
}
