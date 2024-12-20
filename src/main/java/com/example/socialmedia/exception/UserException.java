package com.example.socialmedia.exception;

import org.springframework.stereotype.Service;

@Service
public class UserException extends Exception{

    public String name;

    public UserException(String name){
        super();
    }
    public UserException(){

    }
}
