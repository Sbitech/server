package com.sbitech.service;

import com.github.pagehelper.PageInfo;
import com.sbitech.dto.DisputesQueryDTO;
import com.sbitech.vo.DisputesDetailVO;
import com.sbitech.vo.DisputesVO;

public interface DisputesService {
    PageInfo<DisputesVO> getDisputesByCondition(DisputesQueryDTO queryDTO);

    DisputesDetailVO getDisputesDetail(Long id);
}
