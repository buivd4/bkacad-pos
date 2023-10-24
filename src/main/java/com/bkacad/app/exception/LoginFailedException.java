package com.bkacad.app.exception;

public class LoginFailedException extends Exception{
    public LoginFailedException(String username){
        super("User "+username+" login failed!");
    }    
}
