package com.gearsoftware.notificationapi.services.implementations;

import com.gearsoftware.notificationapi.exceptions.NotificationNotFoundException;
import com.gearsoftware.notificationapi.mapper.NotificationMapper;
import com.gearsoftware.notificationapi.model.dto.NotificationDTO;
import com.gearsoftware.notificationapi.model.entity.Notification;
import com.gearsoftware.notificationapi.repositories.NotificationRepository;
import com.gearsoftware.notificationapi.services.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService implements INotificationService {

    private final NotificationRepository repository;

    private final NotificationMapper mapper;

    @Autowired
    public NotificationService(NotificationRepository repository, NotificationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public NotificationDTO create() {
        // TODO Será criado por meio de fila SQS
        return null;
    }

    @Override
    public Page<NotificationDTO> findAll(String userId) {
        // TODO Refatorar esse método para receber parametros
        return repository.findAllByUserId(userId, PageRequest.of(0, 10))
                .map(mapper::toDTO);
    }

    @Override
    public NotificationDTO findById(String userId, Long id) {
        return mapper.toDTO(findNotificationByIdAndUserId(id, userId));
    }

    @Override
    public void deleteById(String userId, Long id) {
        var notification = findNotificationByIdAndUserId(id, userId);
        notification.setIsActive(false);

        repository.save(notification);
    }

    @Override
    public void markAsRead(String userId, Long id) {
        var notification = findNotificationByIdAndUserId(id, userId);
        notification.setRead(true);
        notification.setReadAt(LocalDateTime.now());

        repository.save(notification);
    }

    private Notification findNotificationByIdAndUserId(Long id, String userId) {
        return repository.findByIdAndUserIdAndIsActive(id, userId, true)
                .orElseThrow(NotificationNotFoundException::new);
    }
}
