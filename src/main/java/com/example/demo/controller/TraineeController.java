package com.example.demo.controller;

import com.example.demo.domain.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/trainees")
public class TraineeController {

    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Trainee getTraineeById(@PathVariable Long id) {
        return traineeService.getTraineeById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Trainee> getTrainees(@RequestParam String grouped) {
        return traineeService.getAllTrainees(grouped);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainee createTrainee(@RequestBody @Valid Trainee trainee) {
        return traineeService.createTrainee(trainee);
    }
}
