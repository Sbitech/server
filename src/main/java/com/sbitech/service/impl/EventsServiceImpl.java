package com.sbitech.service.impl;

import com.sbitech.entity.Events;
import com.sbitech.mapper.EventsMapper;
import com.sbitech.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsMapper eventsMapper;

    @Override
    public List<Events> getCategory() {
        return eventsMapper.getCategory();
    }
}
