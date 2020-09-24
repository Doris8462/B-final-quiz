package com.example.demo.service;

import com.example.demo.commom.Convert;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer getTrainerById(Long id) {
        TrainerEntity trainerEntity = trainerRepository.findById(id).get();
        return Convert.convert(trainerEntity,Trainer.class);
    }
    public List<Trainer> getAllTrainers(String grouped) {
        List<TrainerEntity> trainers = trainerRepository.findAll();
        return trainers.stream()
                .map(trainer -> Convert.convert(trainer,Trainer.class))
                .collect(Collectors.toList());
    }

    public Trainer createTrainer(Trainer trainer) {
        TrainerEntity trainerEntity = Convert.convert(trainer,TrainerEntity.class);
        TrainerEntity savedTrainerEntity = trainerRepository.save(trainerEntity);
        return Convert.convert(savedTrainerEntity,Trainer.class);
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}
