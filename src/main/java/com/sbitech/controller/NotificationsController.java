package com.sbitech.controller;

import com.sbitech.dto.NotificationsDTO;
import com.sbitech.entity.Notifications;
import com.sbitech.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @GetMapping("getNotifications")
    public List<NotificationsDTO> getNotifications(Long refereeId) {
        return notificationsService.getNotifications(refereeId);
    }

}
