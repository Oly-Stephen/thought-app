package com.stephen.thought.models;

import com.stephen.thought.utils.Priorities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDate localDate;
    private boolean isActive = false;
    private boolean isCompleted = false;

    @Builder.Default
    private Priorities priority = Priorities.NONE;

    @PrePersist
    protected void onCreate() {
        localDate = LocalDate.now();
    }


}
