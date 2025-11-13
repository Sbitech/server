package com.sbitech.mapper;

import com.sbitech.entity.Notifications;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationsMapper {

    List<Notifications> getNotifications(Long refereeId);

    boolean markAsRead(Long notificationId);
}
