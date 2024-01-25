package ru.gb.hw.exceptions;


public class CustomerNotExistException extends Exception {
    public CustomerNotExistException() {
    }

    public CustomerNotExistException(String message) {
        super(message);
    }
}