package com.calender.repository;

import com.calender.entity.Calender_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Calender_Repository extends JpaRepository<Calender_Entity,Long> {
    List<Calender_Entity> findByEventName(String eventName);
    List<Calender_Entity> findByEventDate(LocalDate eventDate);
}
/*
Data for testing
[
    {
        "eventName": "Meeting with Clients",
        "eventDate": "2023-01-02"
    },
    {
        "eventName": "Team Building Activity",
        "eventDate": "2023-01-03"
    },
    {
        "eventName": "Product Launch",
        "eventDate": "2023-01-04"
    },
    {
        "eventName": "Conference",
        "eventDate": "2023-01-05"
    },
    {
        "eventName": "Dinner with Friends",
        "eventDate": "2023-01-06"
    },
    {
        "eventName": "Training Workshop",
        "eventDate": "2023-01-07"
    },
    {
        "eventName": "Travel to Paris",
        "eventDate": "2023-01-08"
    },
    {
        "eventName": "Doctor's Appointment",
        "eventDate": "2023-01-09"
    },
    {
        "eventName": "Project Deadline",
        "eventDate": "2023-01-10"
    },
    {
        "eventName": "Gym Session",
        "eventDate": "2023-04-11"
    },
    {
        "eventName": "Vacation in Bali",
        "eventDate": "2023-04-12"
    },
    {
        "eventName": "Job Interview",
        "eventDate": "2023-04-13"
    },
    {
        "eventName": "Team Lunch",
        "eventDate": "2023-04-14"
    },
    {
        "eventName": "Webinar",
        "eventDate": "2023-04-15"
    },
    {
        "eventName": "Family Reunion",
        "eventDate": "2023-04-16"
    },
    {
        "eventName": "Business Trip",
        "eventDate": "2023-04-17"
    },
    {
        "eventName": "Charity Event",
        "eventDate": "2023-04-18"
    },
    {
        "eventName": "Music Concert",
        "eventDate": "2023-04-19"
    },
    {
        "eventName": "Dentist Appointment",
        "eventDate": "2023-04-20"
    }
]
* */