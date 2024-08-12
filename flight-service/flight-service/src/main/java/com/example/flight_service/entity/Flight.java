package com.example.flight_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "Flight")
public class Flight {
    //Flight manager adını depğiştir
    @GeneratedValue(strategy = GenerationType.IDENTITY )
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

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightType() {
        return flightType;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

