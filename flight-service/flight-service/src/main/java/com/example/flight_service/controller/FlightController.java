package com.example.flight_service.controller;

import com.example.flight_service.service.FlightService;
import com.example.flight_service.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/sendTask")
    public ResponseEntity<List<Task>> sendTask() {
        List<Task> response = flightService.sendTaskRequest();
        return ResponseEntity.ok(response);
    }


}

