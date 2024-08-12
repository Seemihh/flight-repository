package com.example.flight_service.controller;

import com.example.flight_service.dto.FlightDTO;
import com.example.flight_service.entity.Flight;
import com.example.flight_service.service.FlightService;
import com.example.flight_service.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {
    private FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
// TODO 18. satır Autowired
    // Dependency injection araştır, autowired yerine ne kullanılabilir,
    @GetMapping("/sendTask/{flightID}")
    public ResponseEntity<List<Task>> sendTask(@PathVariable Long flightID) {
        List<Task> response = flightService.sendTaskRequest(flightID);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/save" )
    public FlightDTO saveEntity(@RequestBody FlightDTO flightDTO){
        return flightService.FlightToDTo(flightService.saveFlight(flightDTO));
    }
    @PutMapping("/update/{id}")
 public FlightDTO update(@RequestBody FlightDTO flightDTO) {
       return  flightService.FlightToDTo(flightService.updateFlight(flightDTO));

    }

    @DeleteMapping ("/remove")
    public FlightDTO remove(@PathVariable Long flightId){
        return flightService.FlightToDTo(flightService.findFlight(flightService.deleteFlight(flightId)));

    }
    @GetMapping("/{id}")
    public FlightDTO findByID(@PathVariable long id){
       return flightService.FlightToDTo(flightService.findFlight(id));

    }

}

