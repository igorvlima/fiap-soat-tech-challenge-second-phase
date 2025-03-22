package com.fastfood.api.application.exceptions;

public class NoItemsFoundException extends RuntimeException {

    public NoItemsFoundException(String message) {
        super(message);
    }
}