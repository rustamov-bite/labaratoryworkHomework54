package com.example.labwork6hw.repositories;

import com.example.labwork6hw.entities.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription, String> {
    Subscription findSubscriptionById(String id);
}
