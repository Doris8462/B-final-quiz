package com.example.demo.service;

import com.example.demo.commom.Convert;
import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.GroupEntity;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.exception.ExceptionEnum;
import com.example.demo.exception.GroupingError;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private TrainerRepository trainerRepository;
    private TraineeRepository traineeRepository;

    public GroupService(GroupRepository groupRepository, TrainerRepository trainerRepository, TraineeRepository traineeRepository) {
        this.groupRepository = groupRepository;
        this.traineeRepository = traineeRepository;
        this.trainerRepository = trainerRepository;
    }

    public List<Group> getGroups() {
        List<GroupEntity> groups = groupRepository.findAll();
        return groups.stream()
                .map(group -> Convert.convert(group, Group.class))
                .collect(Collectors.toList());
    }

    public void renameGroup(Long id, String name) {
        groupRepository.findById(id).get().setName(name);
    }

    public List<Group> Grouping() {
        List<TrainerEntity> trainerEntities = trainerRepository.findAll();
        List<TraineeEntity> traineeEntities = traineeRepository.findAll();
        groupRepository.deleteAll();
        List<GroupEntity> groups = new ArrayList<>();
        if (trainerEntities.size() < 2) {
            throw new GroupingError(ExceptionEnum.DIVIDE_GROUP_EXCEPTION);
        }
        int groupNumber = trainerEntities.size() / 2;
        Collections.shuffle(traineeEntities);
        Collections.shuffle(traineeEntities);
        for(int i=1;i<=groupNumber;i++){
            ArrayList<TraineeEntity> groupTrainees = new ArrayList<TraineeEntity>();
            for (int j = 0; j < traineeEntities.size(); j++) {
                if ((j % groupNumber + 1) == i) {
                    groupTrainees.add(traineeEntities.get(j));
                }
            }
            groups.add(GroupEntity.builder().name(i+"组")
            .trainees(groupTrainees).trainers(trainerEntities.subList(2*i-1, 2*i))
            .build());
        }
        List<GroupEntity> newGroupList = groupRepository.saveAll(groups);

        return newGroupList.stream().map(group -> Convert.convert(group, Group.class))
                .collect(Collectors.toList());
    }
}
