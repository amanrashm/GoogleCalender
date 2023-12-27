package com.calender.controller;

import com.calender.entity.Calender_Entity;
import com.calender.service.Calender_Service_Simply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

// create event
// edit event
// delete event
//get all event by name and date
// Create an APIs like a Google calendar
//1) Create an event in a particular date like birthday , anniversary or any other custom events.
//2) edit the event
//3) delete the event
//4) get api for retrieve the list of all events by event name , date.
//
//This is for spring boot

@RestController
@RequestMapping("/events")
public class Calender_Controller {

    private final Calender_Service_Simply eventService;

    @Autowired
    public Calender_Controller(Calender_Service_Simply eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ModelAndView events(ModelAndView modelAndView){
        return modelAndView ;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }
    /*@PostMapping
    public ResponseEntity<Calender_Entity> createEvent(@RequestBody Calender_Entity event) {
        Calender_Entity createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }*/

    @PutMapping("/{eventId}")
    public ResponseEntity<Calender_Entity> editEvent(@PathVariable Long eventId, @RequestBody Calender_Entity eventDetails) {
        Calender_Entity updatedEvent = eventService.editEvent(eventId, eventDetails);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }

    //http://localhost:8081/events/byname/Meeting%20with%20Clients hit this url to get data
    @GetMapping("/byname/{eventName}")
    public ResponseEntity<List<Calender_Entity>> getEventsByName(@PathVariable String eventName) {
        List<Calender_Entity> events = eventService.getEventsByName(eventName);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/bydate/{date}")
    public ResponseEntity<List<Calender_Entity>> getEventsByDate(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        List<Calender_Entity> events = eventService.getEventsByDate(parsedDate);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/allevents")
    public ResponseEntity<List<Calender_Entity>> getAllEvents() {
        List<Calender_Entity> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
}