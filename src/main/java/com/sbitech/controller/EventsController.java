package com.sbitech.controller;

import com.sbitech.dto.Competition_EventsQueryDTO;
import com.sbitech.entity.Events;
import com.sbitech.service.EventsService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventsController {

    private final EventsService eventsService;

    @GetMapping("/getCategory")
    public List<Events> getCategory() {
        return eventsService.getCategory();
    }

    @GetMapping("/getCompetition_Events")
    public Competition_EventsQueryDTO getCompetition_Events(Long id) {
        val competitionEvents = eventsService.getCompetition_Events(id);
        System.out.println(competitionEvents);
        return competitionEvents;
    }

}
