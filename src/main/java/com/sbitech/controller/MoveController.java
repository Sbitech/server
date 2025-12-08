package com.sbitech.controller;

import com.sbitech.entity.Move;
import com.sbitech.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/move")
public class MoveController {

    private final MoveService moveService;

    @GetMapping("/all")
    public List<Move> getAll() {
        return moveService.getAll();
    }

}
