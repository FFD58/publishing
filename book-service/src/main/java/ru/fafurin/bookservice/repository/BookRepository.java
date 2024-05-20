package ru.fafurin.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.bookservice.domen.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
