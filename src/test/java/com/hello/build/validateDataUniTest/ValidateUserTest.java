package com.hello.build.validateDataUniTest;

import com.hello.build.controller.UserController;
import com.hello.build.model.User;
import com.hello.build.repository.UserRepository;
import com.hello.build.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class ValidateUserTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Autowired
    public Errors errors;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateUserExist() {
        Long id = 1L;
        String name = "Daniel";
        String apellido = "Achury";
        User mockUser = User.builder().id(id).name(name).apellido(apellido).build();
        Mockito.when(userService.getUserService(id)).thenReturn(mockUser);
    }

    @Test
    public void validateRegistryUser() {
        Long id = 1L;
        String name = "Daniel";
        String apellido = "Achury";
        User mockUser = User.builder().id(id).name(name).apellido(apellido).build();
        userController.saveUser(mockUser);
        Mockito.when(userService.getUserService(id)).thenReturn(mockUser);
    }

    @Test
    public void validateTimeProces() {
        long startTime = System.nanoTime();
        Long id = 3L;
        User mockUser = User.builder().id(1L).name("Juan").apellido("Gomez").build();
        User mockUser1 = User.builder().id(2L).name("Pedro").apellido("Perez").build();
        User mockUser2 = User.builder().id(3L).name("Santiago").apellido("Arevalo").build();
        userController.saveUser(mockUser);
        userController.saveUser(mockUser1);
        userController.saveUser(mockUser2);
        List<User> users = userController.getfindUsers();
        long endTime = System.nanoTime();
        log.info("Duración: " + (endTime - startTime) / 1e6 + " ms");
        Mockito.when(userController.getfindUsers()).thenReturn(users);
    }
}
