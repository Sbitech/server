package com.sbitech.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbitech.dto.DisputesQueryDTO;
import com.sbitech.vo.DisputesVO;
import com.sbitech.mapper.DisputesMapper;
import com.sbitech.service.DisputesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisputesServiceImpl implements DisputesService {

    @Autowired
    private DisputesMapper disputesMapper;

    @Override
    public PageInfo<DisputesVO> getDisputesByCondition(DisputesQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<DisputesVO> disputes = disputesMapper.disputesPage(
                queryDTO.getStartTime(),
                queryDTO.getEndTime(),
                queryDTO.getEventCategory(),
                queryDTO.getStatus()
        );
        return new PageInfo<>(disputes);
    }
}
