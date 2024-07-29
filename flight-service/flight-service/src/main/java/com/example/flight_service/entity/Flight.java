package com.example.flight_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Flight")
public class Flight {
    //Flight manager adını depğiştir
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "flightNo")
    private String flightNo;
    @Column(name = "flightDate")
    private String flightDate;
    @Column(name = "flightTime")
    private String flightTime;
    @Column(name = "flightType")
    private String flightType;
    @Column(name = "flightStatus")
    private String flightStatus;
    public Flight(long id) {
        this.id = id;
    }

    public Flight() {

    }
}

