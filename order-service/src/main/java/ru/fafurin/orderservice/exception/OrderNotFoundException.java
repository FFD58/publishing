package ru.fafurin.orderservice.exception;

public class OrderNotFoundException extends AppException {
    public OrderNotFoundException(Long id) {
        super(String.format("Order with id: %s not found", id));
    }
}
