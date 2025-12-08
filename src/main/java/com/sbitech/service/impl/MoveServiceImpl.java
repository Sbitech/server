package com.sbitech.service.impl;

import com.sbitech.entity.Move;
import com.sbitech.mapper.MoveMapper;
import com.sbitech.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoveServiceImpl implements MoveService {

    private final MoveMapper moveMapper;

    @Override
    public List<Move> getAll() {
       return moveMapper.getAll();
    }

//    @Scheduled(fixedRate = 10000)
//    public void ScheduledDemo() {
//        System.err.println("Scheduled task executed: " + System.currentTimeMillis());
//    }
}
