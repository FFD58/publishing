package ru.fafurin.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.orderservice.domen.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}

