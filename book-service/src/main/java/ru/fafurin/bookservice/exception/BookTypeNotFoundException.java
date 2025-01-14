package ru.fafurin.bookservice.exception;

public class BookTypeNotFoundException extends AppException {
    public BookTypeNotFoundException(Integer id) {
        super(String.format("Book type with id: %d not found", id));
    }

    public BookTypeNotFoundException(String title) {
        super(String.format("Book type with title: %s not found", title));
    }
}
