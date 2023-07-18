package com.example.demo.repositories;

import com.example.demo.models.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Integer> {

}
