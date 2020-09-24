package com.example.demo.service;

import com.example.demo.commom.Convert;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TraineeService {

    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee getTraineeById(Long id) {
        TraineeEntity traineeEntity = traineeRepository.findById(id).get();
        return Convert.convert(traineeEntity, Trainee.class);
    }

    public List<Trainee> getAllTrainees(Boolean grouped) {
        List<TraineeEntity> trainees = traineeRepository.findAll();
        return trainees.stream()
                .map(trainee -> Convert.convert(trainee, Trainee.class))
                .collect(Collectors.toList());
    }

    public Trainee createTrainee(Trainee trainee) {
        TraineeEntity traineeEntity = Convert.convert(trainee, TraineeEntity.class);
        TraineeEntity savedTraineeEntity = traineeRepository.save(traineeEntity);
        return Convert.convert(savedTraineeEntity, Trainee.class);
    }

    public void deleteTrainee(Long id) {
        traineeRepository.deleteById(id);
    }
}
