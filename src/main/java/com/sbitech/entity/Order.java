package com.sbitech.entity;

import jdk.jfr.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long eventId;
    private Long playerId;
    private Integer ranking;

}
