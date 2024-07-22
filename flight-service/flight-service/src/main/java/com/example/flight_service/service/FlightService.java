package com.example.flight_service.service;


import com.example.flight_service.task.Task;
import com.example.flight_service.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.*;

import org.springframework.web.client.RestTemplate;

@Service
public class FlightService {

    @Autowired
    private RestTemplate restTemplatee;

    public List<Task> sendTaskRequest() {
        String url = "http://localhost:8081/task/process?flightId={value1}";

//        String url = "http://example.com/api/resource?param1={param1}&param2={param2}";
//        String response = restTemplate.getForObject(url, String.class, "value1", "value2");
//
//        System.out.println(response);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//       Map<String, Object> requestEntity = new HashMap<>();
//       requestEntity.put("flightId", 1L);
//       requestEntity.put("status", "landed");
        Task[] tasks = restTemplatee.getForObject(url, Task[].class, 1L);
        //Task[] tasks = responseEntity.getBody();
        return new ArrayList<>(Arrays.asList(tasks));

    }
}
