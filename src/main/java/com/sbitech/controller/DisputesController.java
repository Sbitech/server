package com.sbitech.controller;

import com.github.pagehelper.PageInfo;
import com.sbitech.dto.DisputesQueryDTO;
import com.sbitech.vo.DisputesVO;
import com.sbitech.service.DisputesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/disputes")
public class DisputesController {

    @Autowired
    private DisputesService disputesService;

    @PostMapping("/list")
    public PageInfo<DisputesVO> getDisputesList(@RequestBody DisputesQueryDTO queryDTO) {
        return disputesService.getDisputesByCondition(queryDTO);
    }
}
