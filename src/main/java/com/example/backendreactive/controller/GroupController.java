package com.example.backendreactive.controller;


import com.example.backendreactive.model.Group;
import com.example.backendreactive.model.Team;
import com.example.backendreactive.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/{id}")
    private Mono<Group> getGroups(@PathVariable String id){

        return groupRepository.getGroup(id).log();
    }
}
