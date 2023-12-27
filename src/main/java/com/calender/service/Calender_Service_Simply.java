package com.calender.service;

import com.calender.entity.Calender_Entity;
import com.calender.repository.Calender_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class Calender_Service_Simply{
    private final Calender_Repository eventRepository;

    @Autowired
    public Calender_Service_Simply(Calender_Repository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Calender_Entity createEvent(Calender_Entity event) {
        return eventRepository.save(event);
    }

    public Calender_Entity editEvent(Long eventId, Calender_Entity eventDetails) {
        Optional<Calender_Entity> eventToUpdate = eventRepository.findById(eventId);

        if (eventToUpdate.isPresent()) {
            Calender_Entity updatedEvent = eventToUpdate.get();
            updatedEvent.setEventName(eventDetails.getEventName());
            updatedEvent.setEventDate(eventDetails.getEventDate());
            return eventRepository.save(updatedEvent);
        } else {
            throw new RuntimeException("Event not found with ID: " + eventId);
        }
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<Calender_Entity> getEventsByName(String eventName) {
        return eventRepository.findByEventName(eventName);
    }

    public List<Calender_Entity> getEventsByDate(LocalDate date) {
        return eventRepository.findByEventDate(date);
    }

    public List<Calender_Entity> getAllEvents() {
        return eventRepository.findAll();
    }
}
