package com.example.labwork6hw.dto;

import com.example.labwork6hw.entities.Event;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventDto {
    public static EventDto from(Event event) {
        return EventDto.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .date(event.getDate())
                .build();
    }

    public static List<EventDto> fromList(List<Event> events) {
        List<EventDto> tmp = new ArrayList<>();
        for (Event e : events) {
            tmp.add(from(e));
        }
        return tmp;
    }

    private String title;
    private String description;
    private LocalDate date;
}
