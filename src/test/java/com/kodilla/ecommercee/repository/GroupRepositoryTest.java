package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupRepositoryTest {
    @Autowired
    private GroupRepository groupRepository;

    @Before
    public void prepareDatabase() {
        Group group = new Group(null, "Test", new ArrayList<>());
        groupRepository.save(group);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void create() {
        //Given
        Group group = new Group(2L, "Test", new ArrayList<>());

        //When
        groupRepository.save(group);
        int count = groupRepository.findAll().size();

        //Then
        assertEquals(2, count);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void read() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        //When
        Group readGroup = groupRepository.findById(1L).orElse(null);

        //Then
        assertEquals(group, readGroup);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void update() {
        //Given
        Group group = new Group(1L, "TestTwo", new ArrayList<>());

        //When
        groupRepository.save(group);
        Group updateGroup = groupRepository.findById(1L).orElse(null);

        //Then
        assertEquals(group, updateGroup);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void delete() {
        //When
        groupRepository.deleteById(1L);
        Group deleteGroup = groupRepository.findById(1L).orElse(null);

        //Then
        assertNull(deleteGroup);
    }
}