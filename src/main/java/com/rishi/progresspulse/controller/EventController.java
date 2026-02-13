package com.rishi.progresspulse.controller;

import com.rishi.progresspulse.model.Event;
import com.rishi.progresspulse.repository.EventRepository;
import com.rishi.progresspulse.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/events")
@CrossOrigin(origins = "*")

public class EventController {
    @Autowired
    private EventService eventService;
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }
    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id){
        eventRepository.deleteById(id);
    }




    
}
