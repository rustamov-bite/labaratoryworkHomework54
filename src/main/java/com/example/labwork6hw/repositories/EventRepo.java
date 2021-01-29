package com.example.labwork6hw.repositories;

import com.example.labwork6hw.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, String> {
    Event findEventById(String id);
}
