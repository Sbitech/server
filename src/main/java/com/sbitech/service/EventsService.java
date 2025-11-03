package com.sbitech.service;

import com.sbitech.dto.Competition_EventsQueryDTO;
import com.sbitech.entity.Events;

import java.util.List;

public interface EventsService {

    List<Events> getCategory();

    Competition_EventsQueryDTO getCompetition_Events(Long id);
}
