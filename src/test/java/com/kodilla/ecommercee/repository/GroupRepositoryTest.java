package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
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

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void crudTest() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        //When
        Group saveGroup = groupRepository.save(group);

        group.setName("TestTwo");
        Group updateGroup = groupRepository.save(group);

        groupRepository.deleteById(1L);
        Group deleteGroup = groupRepository.findById(1L).orElse(null);

        //Then
        assertNotEquals(group, saveGroup);
        assertEquals(group, updateGroup);
        assertNull(deleteGroup);
    }
}