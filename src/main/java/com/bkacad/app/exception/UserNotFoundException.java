package com.bkacad.app.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String username){
        super("User "+username+" not found!");
    }    
}
