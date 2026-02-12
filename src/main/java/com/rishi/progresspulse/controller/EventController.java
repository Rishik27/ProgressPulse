package com.rishi.progresspulse.controller;

import com.rishi.progresspulse.model.Event;
import com.rishi.progresspulse.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/events")
@CrossOrigin(origins = "*")

public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }
    @GetMapping
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id){
        eventRepository.deleteById(id);
    }




    
}
