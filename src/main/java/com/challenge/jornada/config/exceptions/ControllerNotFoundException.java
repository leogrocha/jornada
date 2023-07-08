package com.challenge.jornada.config.exceptions;

public class ControllerNotFoundException extends RuntimeException{
    
    public ControllerNotFoundException(String message) {
        super(message);
    }
}
