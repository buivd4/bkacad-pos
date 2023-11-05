package com.bkacad.app.exceptions;

public class WrongUserInputException extends AbstractException{
    public WrongUserInputException(String reason){
        super(reason);
    }
}
