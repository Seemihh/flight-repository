package com.example.flight_service.task;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
public class Task {

    private long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private long flightId;

}
