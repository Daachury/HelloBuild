package com.hello.build.validateDataUniTest;

import com.hello.build.controller.UserController;
import com.hello.build.model.User;
import com.hello.build.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateUserTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateUserExist(){
        Long id= 1L;
        String name= "Daniel";
        String apellido = "Achury";
        User mockUser = User.builder().id(id).name(name).apellido(name).build();
        Mockito.when(userController.getfindUser(id)).thenReturn(mockUser);

    }


}
