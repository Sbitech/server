package com.sbitech.service;

import com.github.pagehelper.PageInfo;
import com.sbitech.dto.HistoryQueryDTO;
import com.sbitech.vo.HistoryVO;

public interface HistoryService {

    PageInfo<HistoryVO> getHistoryByCondition(HistoryQueryDTO queryDTO);

}
