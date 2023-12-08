package com.citi.drawingapp.exception;

public class NoCanvasException extends RuntimeException {

    public NoCanvasException() {
    }

    public NoCanvasException(String message) {
        super(message);
    }
}
