package com.example.flight_service.TaskServiceClient;

import com.example.flight_service.task.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name = "task-service", url = "http://localhost:8081")
public interface TaskServiceClient {

    @GetMapping("/task/process")
    List<Task> getTasksByFlightId(@RequestParam("flightId") Long flightId);
}
