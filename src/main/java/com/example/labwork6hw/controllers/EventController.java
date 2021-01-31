package com.example.labwork6hw.controllers;

import com.example.labwork6hw.dto.EventDto;
import com.example.labwork6hw.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/event")
    public String addEvent(@RequestParam("title") String title,
                           @RequestParam("description") String description) {
        return eventService.addEvent(title, description);
    }

    @GetMapping("/allEvents")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }
}
