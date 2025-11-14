package com.sbitech.mapper;

import com.sbitech.dto.Competition_EventsQueryDTO;
import com.sbitech.entity.Events;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EventsMapper {

    List<Events> getCategory();

    Competition_EventsQueryDTO getCompetition_Events(Long id);

    List<Long> getEventsIdById(String competitionId);

    String getEventNameById(Long eventId);

}
