package com.sbitech.service.impl;

import com.sbitech.dto.CompetitionDTO;
import com.sbitech.mapper.CompetitionMapper;
import com.sbitech.mapper.EventsMapper;
import com.sbitech.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;
    @Autowired
    private EventsMapper eventsMapper;


    @Override
    public CompetitionDTO getCompetitionByTime() {
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        System.out.println("Current Time: " + nowTime);
        CompetitionDTO dto = competitionMapper.getCompetitionByTime(nowTime);
        if (dto == null) {
            return null;
        }
        Map<Long, String> eventsInfo = new HashMap<>();
        List<Long> eventIds = eventsMapper.getEventsIdById(dto.getCompetitionId());
        for (Long eventId : eventIds) {
            eventsInfo.put(eventId, eventsMapper.getEventNameById(eventId));
        }
        dto.setEventsInfo(eventsInfo);
        return dto;
    }
}
