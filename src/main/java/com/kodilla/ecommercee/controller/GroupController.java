package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.GroupNotEmptyException;
import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/group", produces = "application/json")
public class GroupController {
    private GroupService groupService;
    private GroupMapper groupMapper;

    public GroupController(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long id) throws GroupNotFoundException {
        Group group = groupService.getGroup(id).orElseThrow(GroupNotFoundException::new);
        return groupMapper.mapToGroupDto(group);
    }

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getGroups());
    }

    @PostMapping(value = "addGroup", consumes = "application/json")
    public void addGroup(@RequestBody GroupDto group) throws GroupNotFoundException {
        groupService.saveGroup(groupMapper.mapToGroup(group));
    }

    @PutMapping(value = "updateGroup", consumes = "application/json")
    public void updateGroup(@RequestBody GroupDto group) throws GroupNotFoundException {
        groupService.saveGroup(groupMapper.mapToGroup(group));
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(@RequestParam Long id) throws GroupNotFoundException, GroupNotEmptyException {
        Group group = groupService.getGroup(id).orElseThrow(GroupNotFoundException::new);

        if(group.getProducts().isEmpty()) {
            groupService.deleteGroup(group);
        } else {
            throw new GroupNotEmptyException();
        }
    }
}
