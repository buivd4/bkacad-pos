package com.bkacad.app.exceptions;

public class LoginFailedException extends AbstractException{
    public LoginFailedException(String username){
        super("User "+username+" login failed!");
    }    
}
