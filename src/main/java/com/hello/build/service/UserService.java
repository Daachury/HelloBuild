package com.hello.build.service;

import com.hello.build.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public User getUserService(Long id){
        ResponseEntity<User> response = restTemplate.getForEntity("http://localhost:8080/users/"+id,User.class);
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }


}
