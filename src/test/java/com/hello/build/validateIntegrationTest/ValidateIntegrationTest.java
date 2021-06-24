package com.hello.build.validateIntegrationTest;


import com.hello.build.controller.UserController;
import com.hello.build.model.User;
import com.hello.build.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ValidateIntegrationTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController userController;

    //search users results
    @Test
    public void getUserExits() {
        Long id = 1L;
        String name = "Daniel";
        String apellido = "Achury";
        User userTest = User.builder().id(id).name(name).apellido(apellido).build();
        Optional<User> userSave = userRepository.findById(id);
        assertThat(userSave.isPresent(), equalTo(true));
    }

    //term does not match any results
    @Test
    public void getUserNotFund() {
        Long id = 4L;
        Optional<User> userSave = userRepository.findById(id);
        assertThat(userSave.isPresent(), equalTo(false));
    }

    //If the searched term does not match any results, the system should
    //present an error message
    @Test
    public void getUserNotFundMessage() {
        Long id = 4L;
        List<User> users = userController.getfindUsers();
        assertThat(users.contains(id), equalTo(false));
        assertEquals("User not Found " + id, users.contains(id), equals(false));
    }

    // how long search took
    @Test
    public void getUserTimeEstimated() {
        long startTime = System.nanoTime();
        Long id = 3L;
        List<User> users = userController.getfindUsers();
        long endTime = System.nanoTime();
        log.info("Duración: " + (endTime - startTime) / 1e6 + " ms");
        assertThat(users.contains(id), equalTo(false));
    }

}
