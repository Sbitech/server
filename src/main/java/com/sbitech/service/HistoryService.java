package com.sbitech.service;

import com.github.pagehelper.PageInfo;
import com.sbitech.dto.HistoryQueryDTO;
import com.sbitech.vo.HistoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HistoryService {

    PageInfo<HistoryVO> getHistoryByCondition(HistoryQueryDTO queryDTO);

}
