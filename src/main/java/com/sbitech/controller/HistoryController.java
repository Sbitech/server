package com.sbitech.controller;

import com.github.pagehelper.PageInfo;
import com.sbitech.dto.HistoryDetailDTO;
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
    public PageInfo<HistoryVO> list(@RequestBody HistoryQueryDTO queryDTO) {
        return historyService.getHistoryByCondition(queryDTO);
    }

    @GetMapping("/{id}")
    public HistoryDetailDTO getDetail(@PathVariable Long id) {
        return historyService.getDetail(id);
    }
}
/**
 * AllScoresDTO(
 * playerName=张三,
 * eventId=1,
 * eventName=男长拳,
 * playerMatchId=1,
 * scoresOfA=null,
 * scoresOfB=null,
 * scoresOfC=0.3,0.1,0.3,0.1,0.2,0.1,0.3,0,0,0,
 * finalScoreOfA=0,
 * finalScoreOfB=0,
 * finalScoreOfC=1.4,
 * ranking=1,
 * AllFinalScore=1.4)
 *
 * HistoryDetailDTO(
 * id=1,
 * playerName=张三,
 * eventName=男长拳,
 * playerMatchTime=2025-07-25 03:23:12,
 * status=0,
 * eventId=1,
 * playerMatchId=1,
 * scoresOfA=null,
 * scoresOfB=null,
 * scoresOfC=null,
 * finalScoreOfA=0,
 * finalScoreOfB=0,
 * finalScoreOfC=0,
 * ranking=null,
 * AllFinalScore=0)
 */