package com.example.flight_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Flight {
    //Flight manager adını depğiştir
    @Id
    private long id;
    private String flightNo;
    private String flightDate;
    private String flightTime;
    private String flightType;
    private String flightStatus;

    public Flight(long id) {
        this.id = id;
    }

    public Flight() {

    }
}

