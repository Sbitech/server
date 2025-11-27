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
    public CompetitionDTO getCompetitionByTime() {  //通过当前时间判断有无比赛
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());  //获取当前时间
        CompetitionDTO dto = competitionMapper.getCompetitionByTime(nowTime);   //查询当前时间区间的赛事
        if (dto == null) {
            return null;
        }
        Map<Long, String> eventsInfo = new HashMap<>();
        List<Long> eventIds = eventsMapper.getEventsIdById(dto.getCompetitionId()); //通过赛事id获取该赛事中的比赛内容
        for (Long eventId : eventIds) { //把比赛内容放入map中，存在dto中返回
            eventsInfo.put(eventId, eventsMapper.getEventNameById(eventId));
        }
        dto.setEventsInfo(eventsInfo);
        return dto;
    }
}
