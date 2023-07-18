package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name="event_type")
public class EventType {
    @Id
    @Column(name="event_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventTypeId;

    @Column(name = "event_type_name")
    private String eventTypeName;

    @OneToMany(mappedBy = "eventType")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Event> events;

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
