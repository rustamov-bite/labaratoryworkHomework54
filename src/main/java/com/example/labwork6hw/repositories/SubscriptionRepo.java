package com.example.labwork6hw.repositories;

import com.example.labwork6hw.entities.Event;
import com.example.labwork6hw.entities.Subscription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepo extends CrudRepository<Subscription, String> {
    List<Subscription> findSubscriptionsByEmail(String email);
    List<Subscription> findAll();
    boolean existsSubscriptionByEvent(Event event);
    boolean existsSubscriptionByIdAndEmail(String id, String email);
    void deleteSubscriptionByIdAndEmail(String id, String email);
}
