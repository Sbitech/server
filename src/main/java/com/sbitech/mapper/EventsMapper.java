package com.sbitech.mapper;

import com.sbitech.entity.Events;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EventsMapper {
    List<Events> getCategory();
}
