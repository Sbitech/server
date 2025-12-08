package com.sbitech.controller;

import com.github.pagehelper.PageInfo;
import com.sbitech.dto.DisputesQueryDTO;
import com.sbitech.service.DisputesService;
import com.sbitech.vo.DisputesDetailVO;
import com.sbitech.vo.DisputesVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/disputes")
public class DisputesController {

    private final DisputesService disputesService;

    @PostMapping("/list")
    public PageInfo<DisputesVO> getDisputesList(@RequestBody DisputesQueryDTO queryDTO) {
        return disputesService.getDisputesByCondition(queryDTO);
    }

    @GetMapping("detail/{id}")
    public DisputesDetailVO getDisputesDetail(@PathVariable("id") Long id) {
        return disputesService.getDisputesDetail(id);
    }

    @PutMapping("update/{id}")
    public Boolean updateDisputesStatus(
            @PathVariable("id") Long id,
            @RequestParam("reviewOpinion") String reviewOpinion,
            @RequestParam(value = "score", required = false) Float score,
            @RequestParam("status") String status) {
        System.out.println(reviewOpinion);
        return disputesService.updateDisputesStatus(id, reviewOpinion, score, status);
    }

}
