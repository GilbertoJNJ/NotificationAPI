package com.gearsoftware.notificationapi.controllers;

import com.gearsoftware.notificationapi.model.dto.NotificationDTO;
import com.gearsoftware.notificationapi.services.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final INotificationService notificationService;

    @Autowired
    public NotificationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> findAllByUserId(
            @RequestHeader String token
    ) {
        var notifications = notificationService.findAll(token);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> findById(
            @RequestHeader String token,
            @PathVariable Long id
    ) {
        var notification = notificationService.findById(token, id);
        return ResponseEntity.ok(notification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @RequestHeader String token,
            @PathVariable Long id
    ) {
        notificationService.deleteById(token, id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/mark-as-read")
    public ResponseEntity<Void> markAsRead(
            @RequestHeader String token,
            @PathVariable Long id
    ) {
        notificationService.markAsRead(token, id);
        return ResponseEntity.noContent().build();
    }
}
