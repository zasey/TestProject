package com.example.demo.repositories;

import com.example.demo.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Optional<List<Event>> findEventsByEventType(String eventType);
}
