package com.gearsoftware.notificationapi.repositories;

import com.gearsoftware.notificationapi.model.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Page<Notification> findAllByUserId(String tokenId, Pageable pageable);

    Optional<Notification> findByIdAndUserIdAndIsActive(Long id, String userId, boolean isActive);
}
