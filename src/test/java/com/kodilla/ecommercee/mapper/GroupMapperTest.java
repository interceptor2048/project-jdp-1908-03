package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Dawid Nogacz on 23.08.2019
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupMapperTest {
    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void mapToGroupDto() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        //When
        GroupDto groupDto = groupMapper.mapToGroupDto(group);

        //Then
        assertEquals(1L, groupDto.getId(), 0);
        assertEquals("Test", groupDto.getName());
        assertEquals(0, groupDto.getProducts().size());
    }

    @Test
    public void mapToGroup() throws GroupNotFoundException {
        //Given
        GroupDto groupDto = new GroupDto(1L, "Test", new ArrayList<>());

        //When
        Group group = groupMapper.mapToGroup(groupDto);

        //Then
        assertEquals(1L, group.getId(), 0);
        assertEquals("Test", group.getName());
        assertEquals(0, groupDto.getProducts().size());
    }

    @Test
    public void mapToGroupDtoList() {
        //Given
        List<Group> groups = new ArrayList<>();

        Group groupOne = new Group(1L, "Test", new ArrayList<>());
        Group groupTwo = new Group(2L, "Test", new ArrayList<>());
        Group groupThree = new Group(3L, "Test", new ArrayList<>());

        groups.add(groupOne);
        groups.add(groupTwo);
        groups.add(groupThree);

        //When
        List<GroupDto> groupsDto = groupMapper.mapToGroupDtoList(groups);

        //Then
        assertEquals(3, groupsDto.size());
    }
}