package com.sbitech.service.impl;

import com.sbitech.dto.CompetitionDTO;
import com.sbitech.entity.Events;
import com.sbitech.mapper.CompetitionMapper;
import com.sbitech.mapper.EventsMapper;
import com.sbitech.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;
    @Autowired
    private EventsMapper eventsMapper;


    @Override
    public CompetitionDTO getCompetitionByTime() {  //通过当前时间判断有无比赛
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        CompetitionDTO dto = competitionMapper.getCompetitionByTime(nowTime);   //查询当前时间区间的赛事
        if (dto == null) {
            return null;
        }
        List<Long> eventIds = eventsMapper.getEventsIdById(dto.getCompetitionId()); //通过赛事id获取该赛事中的比赛内容
        if(eventIds == null || eventIds.isEmpty()) {
            dto.setEventsInfo(Collections.emptyMap());
            return dto;
        }
        Map<Long,String> eventsInfo=eventsMapper.getEventNameByIds(eventIds)
                .stream()
                .collect(Collectors.toMap(Events::getId, Events::getName));
        dto.setEventsInfo(eventsInfo);
        return dto;
    }
}
