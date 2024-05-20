package ru.fafurin.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.taskservice.domen.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
