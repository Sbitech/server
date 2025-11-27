package com.sbitech.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbitech.dto.HistoryQueryDTO;
import com.sbitech.mapper.HistoryMapper;
import com.sbitech.service.HistoryService;
import com.sbitech.vo.HistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public PageInfo<HistoryVO> getHistoryByCondition(HistoryQueryDTO queryDTO) { //获取历史属于的分页数据
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<HistoryVO> history = historyMapper.historyPage(
                queryDTO.getStartTime(),
                queryDTO.getEndTime(),
                queryDTO.getCategory(),
                queryDTO.getName()
        );
        return new PageInfo<>(history);
    }
}
