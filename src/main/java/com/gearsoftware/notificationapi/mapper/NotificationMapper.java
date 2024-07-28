package com.gearsoftware.notificationapi.mapper;

import com.gearsoftware.notificationapi.model.dto.NotificationDTO;
import com.gearsoftware.notificationapi.model.entity.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDTO toDTO(Notification notification);
}
