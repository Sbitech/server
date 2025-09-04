package com.sbitech.mapper;

import com.sbitech.entity.Disputes;
import com.sbitech.vo.DisputesDetailVO;
import com.sbitech.vo.DisputesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface DisputesMapper {
    List<DisputesVO> disputesPage(@Param("startTime") Date startTime,
                                  @Param("endTime") Date endTime,
                                  @Param("eventCategory") String eventCategory,
                                  @Param("status") String status);

    DisputesDetailVO getDisputesDetail(Long id);
}
