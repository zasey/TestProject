package com.example.demo.services;

import com.example.demo.models.Event;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EventService {
    EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public void save(Event event) {
        eventRepository.save(event);
    }

    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    public List<Event> getPageableEvents(int page, int eventsPerPage){
        return eventRepository.findAll(PageRequest.of(page, eventsPerPage, Sort.by("date"))).getContent();
    }

    public List<Event> getEventsByType(String type){
        return eventRepository.findEventsByEventType(type).orElse(Collections.emptyList());    }

    public List<Event> getPageableEventsByType(String type, int page, int eventsPerPage){
        return eventRepository.findAll(PageRequest.of(page, eventsPerPage, Sort.by("date"))).getContent()
                .stream().filter(event -> event.getEventType().getEventTypeName().equals(type)).toList();    }

}
