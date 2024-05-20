package ru.fafurin.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.orderservice.domen.Order;
import ru.fafurin.orderservice.domen.Status;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByStatus(Status status);
}
