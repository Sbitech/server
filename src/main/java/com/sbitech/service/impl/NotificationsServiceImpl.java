package com.sbitech.service.impl;

import com.sbitech.dto.NotificationsDTO;
import com.sbitech.dto.NotificationsType;
import com.sbitech.entity.Notifications;
import com.sbitech.mapper.NotificationsMapper;
import com.sbitech.service.NotificationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationsServiceImpl implements NotificationsService {

    private final NotificationsMapper notificationsMapper;

    @Override
    public List<NotificationsDTO> getNotifications(Long refereeId) {    //通过裁判id获取对应的通知列表
        List<Notifications> notifications = notificationsMapper.getNotifications(refereeId);
        if (notifications == null || notifications.isEmpty()) return Collections.emptyList();

        return notifications.stream().map(notification -> {
            NotificationsDTO notificationDTO = new NotificationsDTO();
            notificationDTO.setId(notification.getId());
            notificationDTO.setTitle(notification.getTitle());
            notificationDTO.setContent(notification.getContent());
            notificationDTO.setTime(notification.getTime());

            // 简洁地映射 type -> NotificationsType
            notificationDTO.setType(
                    notification.getType() == null ? NotificationsType.SYSTEM
                            : (notification.getType() == 1 ? NotificationsType.TASK
                            : (notification.getType() == 0 ? NotificationsType.SYSTEM : NotificationsType.APPEAL))
            );

            // 将 isRead 映射为 boolean（默认 false）
            notificationDTO.setIsRead(notification.getIsRead() != null && notification.getIsRead() == 1);

            return notificationDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean markAsRead(Long notificationId) {    //标记已读
        return notificationsMapper.markAsRead(notificationId);
    }

    @Override
    public boolean markAsDeleted(Long notificationId) { //标记已删除（假删除，只是显示）
        return notificationsMapper.markAsDeleted(notificationId);
    }
}
