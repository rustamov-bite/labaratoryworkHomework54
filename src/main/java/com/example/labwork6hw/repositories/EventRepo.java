package com.example.labwork6hw.repositories;

import com.example.labwork6hw.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepo extends CrudRepository<Event, String> {
    Event findEventById(String id);
    List<Event> findAll();
    boolean existsEventById(String id);
}
