package com.sbitech.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbitech.dto.DisputesQueryDTO;
import com.sbitech.mapper.DisputesMapper;
import com.sbitech.service.DisputesService;
import com.sbitech.vo.DisputesDetailVO;
import com.sbitech.vo.DisputesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisputesServiceImpl implements DisputesService {

    @Autowired
    private DisputesMapper disputesMapper;

    @Override
    public PageInfo<DisputesVO> getDisputesByCondition(DisputesQueryDTO queryDTO) { //获取争议信息的分页数据
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<DisputesVO> disputes = disputesMapper.disputesPage(
                queryDTO.getStartTime(),
                queryDTO.getEndTime(),
                queryDTO.getEventCategory(),
                queryDTO.getStatus()
        );
        return new PageInfo<>(disputes);
    }

    @Override
    public DisputesDetailVO getDisputesDetail(Long id) {    //获取详情数据
        return disputesMapper.getDisputesDetail(id);
    }

    @Override
    public Boolean updateDisputesStatus(Long id, String reviewOpinion, Float score, String status) {    //更新申诉状态
        Integer rows = 0;
        if(status.equals("1")){
            rows = disputesMapper.updateDisputesStatus1(id, reviewOpinion, score, status);
        }else{
            rows = disputesMapper.updateDisputesStatus2(id, reviewOpinion, status);
        }
        return rows != null && rows > 0;
    }
}
