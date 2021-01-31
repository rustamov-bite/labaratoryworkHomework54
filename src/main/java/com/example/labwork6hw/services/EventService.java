package com.example.labwork6hw.services;

import com.example.labwork6hw.dto.EventDto;
import com.example.labwork6hw.entities.Event;
import com.example.labwork6hw.repositories.EventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepo eventRepo;

    public String addEvent(String title, String description) {
         Event event = Event.builder()
                .id(eventRepo.findAll().size() + 1 + "")
                .title(title)
                .description(description)
                .date(getDate())
                .build();
         eventRepo.save(event);
         return "You successfully added the event.";
    }

    public List<EventDto> getAllEvents() {
        return EventDto.fromList(eventRepo.findAll());
    }

    private LocalDate getDate() {
        Random random = new Random();
        int year = random.nextInt(5) + 2010;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(25) + 1;
        return LocalDate.of(year, month, day);
    }
}
