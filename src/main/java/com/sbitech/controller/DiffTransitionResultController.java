package com.sbitech.controller;

import com.sbitech.entity.DiffTransitionResult;
import com.sbitech.service.DiffTransitionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin
@RestController
@RequestMapping("/diffTransitionResult")
public class DiffTransitionResultController {

    private DiffTransitionResult diff;

    @Autowired
    private DiffTransitionResultService diffTransitionResultService;

    @PostMapping("/upDiffTransitionResult")
    public boolean upDiffTransitionResult(@RequestBody DiffTransitionResult diffTransitionResult) {

        try {
            diff=diffTransitionResult;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.err.println(time+"  内容："+diff);
        }
        return true;
//        System.out.println(diffTransitionResult);
//         diffTransitionResultService.upDiffTransitionResult(diffTransitionResult);
    }

    @GetMapping("/getDiffTransitionResult")
    public DiffTransitionResult getDiffTransitionResult() {
        DiffTransitionResult polled=diff;
        diff=null;
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.err.println(time+"  当前队列内容："+diff);
        return polled;
//        return diffTransitionResultService.getDiffTransitionResult();
    }

}
