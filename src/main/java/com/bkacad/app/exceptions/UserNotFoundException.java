package com.bkacad.app.exceptions;

public class UserNotFoundException extends AbstractException{
    public UserNotFoundException(String username){
        super("User "+username+" not found!");
    }    
}
