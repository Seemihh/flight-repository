package com.example.flight_service.service;


import com.example.flight_service.TaskServiceClient.TaskServiceClient;
import com.example.flight_service.dto.FlightDTO;
import com.example.flight_service.entity.Flight;
import com.example.flight_service.repository.FlightRepository;
import com.example.flight_service.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.web.client.RestTemplate;

@Service
public class FlightService {

    //    @Autowired
//    private RestTemplate restTemplatee;
    private TaskServiceClient taskServiceClient;
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository, TaskServiceClient taskServiceClient) {
        this.flightRepository = flightRepository;
        this.taskServiceClient = taskServiceClient;
    }
// TODO restTemplate yerine feign Client araştır


    public List<Task> sendTaskRequest(Long flightID) {
        return taskServiceClient.getTasksByFlightId(flightID);
    }

//    public List<Task> sendTaskRequest(Long flightID) {
//        String url = "http://localhost:8081/task/process?flightId={value1}";
//
////        String url = "http://example.com/api/resource?param1={param1}&param2={param2}";
////        String response = restTemplate.getForObject(url, String.class, "value1", "value2");
////
////        System.out.println(response);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
////       Map<String, Object> requestEntity = new HashMap<>();
////       requestEntity.put("flightId", 1L);
////       requestEntity.put("status", "landed");
//        Task[] tasks = restTemplatee.getForObject(url, Task[].class, flightID);
//        //Task[] tasks = responseEntity.getBody();
//        return new ArrayList<>(Arrays.asList(tasks));
//    }

    public Flight saveFlight(FlightDTO flightDTO) {
        Flight newFlight = new Flight();
        newFlight.setId(flightDTO.getId());
        newFlight.setFlightDate(flightDTO.getFlightDate());
        newFlight.setFlightNo(flightDTO.getFlightNo());
        newFlight.setFlightType(flightDTO.getFlightType());
        newFlight.setFlightStatus(flightDTO.getFlightStatus());
        newFlight.setFlightTime(flightDTO.getFlightTime());
        flightRepository.save(newFlight);
        return newFlight;
    }

    public Flight updateFlight(FlightDTO flightDTO) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightDTO.getId());

        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flight.setFlightDate(flightDTO.getFlightDate());
            flight.setFlightNo(flightDTO.getFlightNo());
            flight.setFlightType(flightDTO.getFlightType());
            flight.setFlightStatus(flightDTO.getFlightStatus());
            flight.setFlightTime(flightDTO.getFlightTime());
            flightRepository.save(flight);
            return flight;
        } else {

            return null;
        }
    }

    public long deleteFlight(long flight_ID) {
        flightRepository.deleteById(flight_ID);
        return flight_ID;
    }

    public Flight findFlight(long flightId) {
        Optional<Flight> myFlight = flightRepository.findById(flightId);
        return myFlight.get();

    }

    public FlightDTO FlightToDTo(Flight flight) {
        FlightDTO myFlight = new FlightDTO();
        myFlight.setId(flight.getId());
        myFlight.setFlightDate(flight.getFlightDate());
        myFlight.setFlightStatus(flight.getFlightStatus());
        myFlight.setFlightNo(flight.getFlightNo());
        return myFlight;
    }

}
