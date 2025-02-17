package ru.fafurin.taskservice.exception;

public class UserNotFoundException extends AppException {
    public UserNotFoundException(Long id) {
        super(String.format("User with id: %s not found", id));
    }
}
