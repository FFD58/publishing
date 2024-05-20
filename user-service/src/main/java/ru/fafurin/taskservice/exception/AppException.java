package ru.fafurin.taskservice.exception;

public class AppException extends RuntimeException {

    public AppException(String message) {
        super(message);
    }
}
