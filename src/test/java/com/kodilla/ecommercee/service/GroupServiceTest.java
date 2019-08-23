package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dawid Nogacz on 23.08.2019
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GroupServiceTest {
    @Autowired
    private GroupService groupService;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getGroup() throws GroupNotFoundException {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        groupService.saveGroup(group);

        //When
        Group getGroup = groupService.getGroup(1L).orElseThrow(GroupNotFoundException::new);

        //Then
        assertEquals(group, getGroup);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getGroups() {
        //Given
        Group groupOne = new Group(1L, "Test", new ArrayList<>());
        Group groupTwo = new Group(2L, "Test", new ArrayList<>());
        Group groupThree = new Group(3L, "Test", new ArrayList<>());

        groupService.saveGroup(groupOne);
        groupService.saveGroup(groupTwo);
        groupService.saveGroup(groupThree);

        groupService.getGroups().forEach(System.out::println);

        //When
        List<Group> groups = groupService.getGroups();

        //Then
        assertEquals(3, groups.size());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void saveGroup() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        //When
        Group groupSave = groupService.saveGroup(group);
        group.setId(groupSave.getId());

        //Then
        assertEquals(group, groupSave);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deleteGroup() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        groupService.saveGroup(group);

        //When
        groupService.deleteGroup(group);
        int countGroup = groupService.getGroups().size();

        //Then
        assertEquals(0, countGroup);
    }


}