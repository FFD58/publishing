package ru.fafurin.taskservice.exception;

public class ProfileNotFoundException extends AppException {
    public ProfileNotFoundException(Long id) {
        super(String.format("Profile with id: %s not found", id));
    }
}
