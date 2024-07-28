package com.gearsoftware.notificationapi.model.entity;

import com.gearsoftware.notificationapi.model.enums.Priority;
import com.gearsoftware.notificationapi.model.enums.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "not_notification")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "not_id")
    private Long id;

    @Column(name = "not_user_id", nullable = false)
    private String userId;

    @Column(name = "not_title", nullable = false)
    private String title;

    @Column(name = "not_message", nullable = false)
    private String message;

    @Column(name = "not_type")
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Column(name = "not_created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "not_read")
    private Boolean read = false;

    @Column(name = "not_read_at")
    private LocalDateTime readAt;

    @Column(name = "not_priority")
    @Enumerated(value = EnumType.STRING)
    private Priority priority;

    @Column(name = "not_link")
    private String link;

    @Column(name = "not_is_active")
    private Boolean isActive = true;
}
