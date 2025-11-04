package com.sbitech.controller;

import com.sbitech.entity.Move;
import com.sbitech.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/move")
public class MoveController {
    @Autowired
    private MoveService moveService;

    @GetMapping("/all")
    public List<Move> getAll() {
        return moveService.getAll();
    }

}
