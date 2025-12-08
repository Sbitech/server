package com.sbitech.controller;

import com.github.pagehelper.PageInfo;
import com.sbitech.dto.HistoryDetailDTO;
import com.sbitech.dto.HistoryQueryDTO;
import com.sbitech.service.HistoryService;
import com.sbitech.vo.HistoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
@CrossOrigin
public class HistoryController {

    private final HistoryService historyService;

    @PostMapping("/list")
    public PageInfo<HistoryVO> list(@RequestBody HistoryQueryDTO queryDTO) {
        return historyService.getHistoryByCondition(queryDTO);
    }

    @GetMapping("/{id}")
    public HistoryDetailDTO getDetail(@PathVariable Long id) {
        return historyService.getDetail(id);
    }
}

