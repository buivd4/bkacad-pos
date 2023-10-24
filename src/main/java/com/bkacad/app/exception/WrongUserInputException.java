package com.bkacad.app.exception;

public class WrongUserInputException extends Exception{
    public WrongUserInputException(String reason){
        super(reason);
    }
}
