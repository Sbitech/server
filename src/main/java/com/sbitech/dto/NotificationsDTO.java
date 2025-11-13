package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationsDTO {

    private Long id;
    private String title;
    private String content;
    private NotificationsType type;
    private Boolean isRead;

}
