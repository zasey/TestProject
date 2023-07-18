package com.example.demo.controllers;

import com.example.demo.models.Event;
import com.example.demo.services.EventService;
import com.example.demo.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class MainController {

    private EventService eventService;
    private EventTypeService eventTypeService;

    @Autowired
    public MainController(EventService eventService, EventTypeService eventTypeService) {
        this.eventService = eventService;
        this.eventTypeService = eventTypeService;
    }

    @ResponseBody
    @GetMapping("/events")
    List<Event> index(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "books_per_page", required = false) Integer booksPerPage,
            @RequestParam(value = "type", required = false) String type){
        List<Event> events;
        if(type != null)
            if(page != null && booksPerPage != null)
                events = eventService.getPageableEventsByType(type ,page, booksPerPage);
            else
                events = eventService.getEventsByType(type);
        else
            if(page != null && booksPerPage != null)
                events = eventService.getPageableEvents(page, booksPerPage);
            else
                events = eventService.getEvents();

        return events;
    }

    @PostMapping("/add")
    ResponseEntity<HttpStatus> addEvent(@RequestBody Event event){

        eventService.save(event);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
