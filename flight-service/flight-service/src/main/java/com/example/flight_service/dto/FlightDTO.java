package com.example.flight_service.dto;

import com.example.flight_service.entity.Flight;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data

public  class FlightDTO {
    private  long id;
    private  String flightNo;
    private  String flightDate;
    private  String flightTime;
    private  String flightType;
    private  String flightStatus;
    public FlightDTO() {

    }

    public long getId() {
        return id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getFlightDate() {
        return flightDate;
    }






    public String getFlightTime() {
            return flightTime;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public void setId(long id) {
        this.id = id;
    }
}
