package com.citi.drawingapp.exception;

public class OutOfCanvasException extends RuntimeException{
    public OutOfCanvasException() {
    }

    public OutOfCanvasException(String message) {
        super(message);
    }
}
