package com.example.labwork6hw.controllers;

import com.example.labwork6hw.dto.SubscriptionDto;
import com.example.labwork6hw.services.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/subscription/{eventId}")
    public String addSubscription(@PathVariable("eventId") String eventId,
                                                @RequestParam("email") String email) {
        return subscriptionService.subscribeToEvent(eventId, email);
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDto> getAllSubscriptions(@RequestParam("email") String email) {
        return subscriptionService.getSubscriptionsByEmail(email);
    }

    @PostMapping("/subscription/{id}")
    public String deleteSubscription(@PathVariable("id") String id,
                                     @RequestParam("email") String email) {
        return subscriptionService.deleteSubscription(id, email);
    }
}
