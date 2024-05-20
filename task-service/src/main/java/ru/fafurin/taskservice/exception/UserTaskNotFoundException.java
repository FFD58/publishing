package ru.fafurin.taskservice.exception;

public class UserTaskNotFoundException extends AppException {
    public UserTaskNotFoundException(Long id) {
        super(String.format("User task with id: %s not found", id));
    }
}
