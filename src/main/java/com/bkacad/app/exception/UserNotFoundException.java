package com.bkacad.app.exception;

public class UserNotFoundException extends AbstractException{
    public UserNotFoundException(String username){
        super("User "+username+" not found!");
    }    
}
