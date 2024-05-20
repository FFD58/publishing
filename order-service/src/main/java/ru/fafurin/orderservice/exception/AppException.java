package ru.fafurin.orderservice.exception;

public class AppException extends RuntimeException {

    public AppException(String message) {
        super(message);
    }
}
