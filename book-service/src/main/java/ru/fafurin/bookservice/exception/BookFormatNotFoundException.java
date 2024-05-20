package ru.fafurin.bookservice.exception;

public class BookFormatNotFoundException extends AppException {
    public BookFormatNotFoundException(Integer id) {
        super(String.format("Book format with id: %d not found", id));
    }
    public BookFormatNotFoundException(String title) {
        super(String.format("Book format with title: %s not found", title));
    }
}
