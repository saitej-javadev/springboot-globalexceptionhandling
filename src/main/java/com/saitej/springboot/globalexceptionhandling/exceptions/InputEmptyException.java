package com.saitej.springboot.globalexceptionhandling.exceptions;

public class InputEmptyException extends Exception {

    public InputEmptyException() {
        super();
    }


    public InputEmptyException(String message) {
        super(message);
    }
}
