package com.example.demo.controller;
import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.GroupEntity;
import com.example.demo.service.GroupService;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getGroups() {
        return groupService.Grouping();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void renameGroup(@PathVariable Long id, @RequestParam String name) {
        groupService.renameGroup(id,name);
    }

}