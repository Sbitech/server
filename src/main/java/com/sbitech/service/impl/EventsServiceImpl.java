package com.sbitech.service.impl;

import com.sbitech.dto.Competition_EventsQueryDTO;
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
    public List<Events> getCategory() { //获取所有比赛的类别
        return eventsMapper.getCategory();
    }

    @Override
    public Competition_EventsQueryDTO getCompetition_Events(Long id) {  //通过赛事id获取该赛事中的比赛内容
        return eventsMapper.getCompetition_Events(id);
    }
}
