package com.sbitech.controller;

import com.github.pagehelper.PageInfo;
import com.sbitech.dto.HistoryQueryDTO;
import com.sbitech.service.HistoryService;
import com.sbitech.vo.HistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
@CrossOrigin
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PostMapping("/list")
    public PageInfo<HistoryVO> list(@RequestBody HistoryQueryDTO queryDTO){
        return historyService.getHistoryByCondition(queryDTO);
    }

}
