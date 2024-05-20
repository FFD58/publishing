package ru.fafurin.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.bookservice.domen.BookType;

import java.util.Optional;

public interface BookTypeRepository extends JpaRepository<BookType, Integer> {
    Optional<BookType> findByTitle(String title);
}
