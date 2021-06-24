package com.hello.build.execption;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super("User not Found "+ id);
    }
}
