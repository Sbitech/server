package com.sbitech.service;

import com.sbitech.dto.NotificationsDTO;

import java.util.List;

public interface NotificationsService {

    List<NotificationsDTO> getNotifications(Long refereeId);

    boolean markAsRead(Long notificationId);

    boolean markAsDeleted(Long notificationId);
}
