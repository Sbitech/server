package com.sbitech.service.impl;

import com.sbitech.dto.NotificationsDTO;
import com.sbitech.dto.NotificationsType;
import com.sbitech.entity.Notifications;
import com.sbitech.mapper.NotificationsMapper;
import com.sbitech.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationsServiceImpl implements NotificationsService {

    @Autowired
    private NotificationsMapper notificationsMapper;

    @Override
    public List<NotificationsDTO> getNotifications(Long refereeId) {    //通过裁判id获取对应的通知列表
        List<NotificationsDTO> dto = new ArrayList<>();
        List<Notifications> notifications = notificationsMapper.getNotifications(refereeId);
        for (Notifications notification : notifications) {
            NotificationsDTO notificationDTO = new NotificationsDTO();
            notificationDTO.setId(notification.getId());
            notificationDTO.setTitle(notification.getTitle());
            notificationDTO.setContent(notification.getContent());
            notificationDTO.setTime(notification.getTime());
            if (notification.getType()==0){
                notificationDTO.setType(NotificationsType.SYSTEM);
            }else if (notification.getType()==1){
                notificationDTO.setType(NotificationsType.TASK);
            }else{
                notificationDTO.setType(NotificationsType.APPEAL);
            }

            if (notification.getIsRead()==0){
                notificationDTO.setIsRead(false);
            }else if (notification.getIsRead()==1){
                notificationDTO.setIsRead(true);
            }
            dto.add(notificationDTO);
        }
        return dto;
    }

    @Override
    public boolean markAsRead(Long notificationId) {    //标记已读
        if(notificationsMapper.markAsRead(notificationId)){
            return true;
        }
        return false;
    }

    @Override
    public boolean markAsDeleted(Long notificationId) { //标记已删除（假删除，只是显示）
        if(notificationsMapper.markAsDeleted(notificationId)){
            return true;
        }
        return false;
    }
}
