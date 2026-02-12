package com.rishi.progresspulse.repository;

import com.rishi.progresspulse.model.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByUserId(Long userId);

    
}
