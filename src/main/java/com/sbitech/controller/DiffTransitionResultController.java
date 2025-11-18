package com.sbitech.controller;

import com.sbitech.entity.DiffTransitionResult;
import com.sbitech.service.DiffTransitionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;

@CrossOrigin
@RestController
@RequestMapping("/diffTransitionResult")
public class DiffTransitionResultController {

    private Queue<DiffTransitionResult> diff=new LinkedList<>();

    @Autowired
    private DiffTransitionResultService diffTransitionResultService;

    @PostMapping("/upDiffTransitionResult")
    public boolean upDiffTransitionResult(@RequestBody DiffTransitionResult diffTransitionResult) {
        try {
            diff.offer(diffTransitionResult);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.err.println(time+"  插入：当前内容："+diff);
            System.err.println(time+"  当前内容长度："+diff.size());

        }
        return true;
//        System.out.println(diffTransitionResult);
//         diffTransitionResultService.upDiffTransitionResult(diffTransitionResult);
    }

    @GetMapping("/getDiffTransitionResult")
    public DiffTransitionResult getDiffTransitionResult() {
        DiffTransitionResult polled=diff.poll();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.err.println(time+"  弹出：当前内容："+diff);
        System.err.println(time+"  当前内容长度："+diff.size());
        return polled;
//        return diffTransitionResultService.getDiffTransitionResult();
    }
    @GetMapping("/clearQueue")
    public String clearQueue() {
        diff.clear();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.err.println(time+"  清空队列：当前内容："+diff);
        System.err.println(time+"  当前内容长度："+diff.size());
        return "队列已清空";
    }

}
