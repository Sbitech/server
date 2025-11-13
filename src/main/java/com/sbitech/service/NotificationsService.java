package com.sbitech.service;

import com.sbitech.dto.NotificationsDTO;
import com.sbitech.entity.Notifications;

import java.util.List;

public interface NotificationsService {

    List<NotificationsDTO> getNotifications(Long refereeId);

}
