package ru.fafurin.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.taskservice.domen.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
