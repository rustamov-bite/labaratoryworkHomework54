package com.example.labwork6hw.services;

import com.example.labwork6hw.dto.SubscriptionDto;
import com.example.labwork6hw.entities.Event;
import com.example.labwork6hw.entities.Subscription;
import com.example.labwork6hw.repositories.EventRepo;
import com.example.labwork6hw.repositories.SubscriptionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepo subscriptionRepo;
    private final EventRepo eventRepo;

    public String subscribeToEvent(String eventId, String email) {
        String msg;
        Event event = eventRepo.findEventById(eventId);
        if (eventDateIsInFuture(event) && eventRepo.existsEventById(eventId)) {
            if (!subscriptionRepo.existsSubscriptionByEvent(event)) {
                Subscription subscription = Subscription.builder()
                        .id(subscriptionRepo.findAll().size() + 1 + "")
                        .email(email)
                        .event(event)
                        .localDate(LocalDate.now())
                        .build();
                subscriptionRepo.save(subscription);
                msg = "You successfully subscribed for the event. Its ID-" + event.getId();
            } else {
                msg = "You already subscribed for this event. Its ID-" + event.getId();
            }
        } else if (!eventRepo.existsEventById(eventId)) {
            msg = "There is no event with such ID";
        } else {
            msg = "Event has already passed. Its ID-" + event.getId();
        }
        return msg;
    }

    public List<SubscriptionDto> getSubscriptionsByEmail(String email) {
        return SubscriptionDto.fromList(subscriptionRepo.findSubscriptionsByEmail(email));
    }

    public String deleteSubscription(String id, String email) {
        String msg;
        if (subscriptionRepo.existsSubscriptionByIdAndEmail(id, email)) {
            subscriptionRepo.deleteSubscriptionByIdAndEmail(id, email);
            msg = "You successfully deleted subscription by ID-" + id + " for email-" + email;
        } else {
            msg = "There is no such ID or email";
        }
        return msg;
    }


    private boolean eventDateIsInFuture(Event event) {
        return event.getDate().isAfter(LocalDate.now());
    }
}
