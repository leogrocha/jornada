package com.challenge.jornada.infra.exceptions;

public class ControllerNotFoundException extends RuntimeException{
    
    public ControllerNotFoundException(String message) {
        super(message);
    }
}
