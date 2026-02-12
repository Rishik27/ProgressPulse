package com.rishi.progresspulse.service;

import com.rishi.progresspulse.model.Event;
import com.rishi.progresspulse.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository repository){
        this.eventRepository = repository;
    }

    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    public List<Event> getUserEvents(Long userId){
        return eventRepository.findByUserId(userId);
    }
    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }
    
}
