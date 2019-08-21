package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.GroupNotEmptyException;
import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dawid Nogacz on 21.08.2019
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/group", produces = "application/json")
public class GroupController {
    private GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping(value = "getGroup")
    private Group getGroup(@RequestParam Long id) throws GroupNotFoundException {
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    @GetMapping(value = "getGroups")
    private List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @PostMapping(value = "addGroup", consumes = "application/json")
    public void addGroup(@RequestBody Group group) {
        groupRepository.save(group);
    }

    @PutMapping(value = "updateGroup", consumes = "application/json")
    public void updateGroup(@RequestBody Group group) {
        groupRepository.save(group);
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(@RequestParam Long id) throws GroupNotFoundException, GroupNotEmptyException {
        Group group = groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);

        if(group.getProducts().isEmpty()) {
            groupRepository.delete(group);
        } else {
            throw new GroupNotEmptyException();
        }
    }
}
