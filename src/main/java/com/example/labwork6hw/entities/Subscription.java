package com.example.labwork6hw.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "subscription")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Subscription {
    @Id
    private String id;
    private Event event;
    private String email;
    private LocalDate localDate;
}
