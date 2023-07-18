package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="event")
public class Event {
    @Id
    @Column(name="event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(name = "event_name")
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "event_type_id", referencedColumnName = "event_type_id")
    private EventType eventType;

    @Column(name="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
