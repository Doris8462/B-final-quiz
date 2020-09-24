package com.example.demo.controller;

import com.example.demo.domain.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Trainer getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Trainer> getTrainers(@RequestParam String grouped) {
        return trainerService.getAllTrainers(grouped);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer createTrainer(@RequestBody @Valid Trainer trainer) {
        return trainerService.createTrainer(trainer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
    }
}