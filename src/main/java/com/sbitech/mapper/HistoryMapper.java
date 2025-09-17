package com.sbitech.mapper;

import com.github.pagehelper.PageInfo;
import com.sbitech.vo.HistoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface HistoryMapper {

    List<HistoryVO> historyPage(@Param("startTime") Date startTime,
                                @Param("endTime") Date endTime,
                                @Param("category") String category,
                                @Param("name") String name);

}
