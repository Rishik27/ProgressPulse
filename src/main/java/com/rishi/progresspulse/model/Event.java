package com.rishi.progresspulse.model;

import jakarta.persistence.*;
import java.time.LocalDate; //Importing LocalDate for date handling

import org.springframework.cglib.core.Local;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //userid
    private String title; //title of the event created
    private String category; //category of the event
    private LocalDate date; //Use LocalDate 

    private LocalDate startDate; //Starting date
    private String description; //Description

    public Event() {
        // Default constructor
    }

    public Event(String title, String category, LocalDate startDate, String description) {
        this.title = title;
        this.category = category;
        this.startDate = startDate;
        this.description = description;
    }

    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public LocalDate getStartDate(){
        return date;
    }
    public String getDescription(){
        return description;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }
    public void setDescription(String description){
        this.description = description;
    }

}
