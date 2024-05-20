package ru.fafurin.bookservice.exception;

public class AppException extends RuntimeException {

    public AppException(String message) {
        super(message);
    }
}
