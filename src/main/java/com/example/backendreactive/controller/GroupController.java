package com.example.backendreactive.controller;


import com.example.backendreactive.model.Group;
import com.example.backendreactive.model.Groups;
import com.example.backendreactive.model.Team;
import com.example.backendreactive.repository.GroupRepository;
import com.example.backendreactive.repository.GroupsRepository;
import com.example.backendreactive.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupsService groupsService;

    @GetMapping("/{id}")
    private Mono<Group> getGroup(@PathVariable String id){
        return groupsService.getGroupByName(id).log();
        //return groupRepository.getGroup(id).log();
    }

    @GetMapping("")
    private Flux<Group> getAllGroups(){
        return groupRepository.getAllGroups();
    }

    @GetMapping("all")
    private Flux<Groups> findAllGroups(){
        return groupsService.getAllGroups();
    }
}
