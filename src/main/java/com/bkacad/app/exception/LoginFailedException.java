package com.bkacad.app.exception;

public class LoginFailedException extends AbstractException{
    public LoginFailedException(String username){
        super("User "+username+" login failed!");
    }    
}
