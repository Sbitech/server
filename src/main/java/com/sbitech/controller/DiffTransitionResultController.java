package com.sbitech.controller;

import com.sbitech.entity.DiffTransitionResult;
import com.sbitech.service.DiffTransitionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/diffTransitionResult")
public class DiffTransitionResultController {

    @Autowired
    private DiffTransitionResultService diffTransitionResultService;

    @PostMapping("/upDiffTransitionResult")
    public boolean upDiffTransitionResult(@RequestBody DiffTransitionResult diffTransitionResult) {

        return diffTransitionResultService.upDiffTransitionResult(diffTransitionResult);
    }

    @GetMapping("/getDiffTransitionResult")
    public DiffTransitionResult getDiffTransitionResult() {
        return diffTransitionResultService.getDiffTransitionResult();
    }

}
