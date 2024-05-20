package ru.fafurin.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.taskservice.domen.UserTask;

public interface UserTaskRepository extends JpaRepository<UserTask, Long> {
}
