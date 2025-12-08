package com.sbitech.controller;

import com.sbitech.dto.NotificationsDTO;
import com.sbitech.service.NotificationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationsController {

    private final NotificationsService notificationsService;

    @GetMapping("getNotifications")
    public List<NotificationsDTO> getNotifications(Long refereeId) {
        return notificationsService.getNotifications(refereeId);
    }

    @PostMapping("/markAsRead")
    public boolean markAsRead(@RequestBody NotificationsDTO notificationsDTO) {
        return notificationsService.markAsRead(notificationsDTO.getId());
    }

    @PostMapping("/markAsDeleted")
    public boolean markAsDeleted(@RequestBody NotificationsDTO notificationsDTO) {
        return notificationsService.markAsDeleted(notificationsDTO.getId());
    }

}
