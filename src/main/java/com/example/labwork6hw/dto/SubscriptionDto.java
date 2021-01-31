package com.example.labwork6hw.dto;

import com.example.labwork6hw.entities.Event;
import com.example.labwork6hw.entities.Subscription;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscriptionDto {
    public static SubscriptionDto from(Subscription subscription) {
        return SubscriptionDto.builder()
                .event(subscription.getEvent())
                .date(subscription.getLocalDate())
                .build();
    }

    public static List<SubscriptionDto> fromList(List<Subscription> subscriptions) {
        List<SubscriptionDto> tmp = new ArrayList<>();
        for (Subscription s : subscriptions) {
            tmp.add(from(s));
        }
        return tmp;
    }
    private Event event;
    private LocalDate date;
}
