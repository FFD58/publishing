package ru.fafurin.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.bookservice.domen.BookFormat;

import java.util.Optional;

public interface BookFormatRepository extends JpaRepository<BookFormat, Integer> {
    Optional<BookFormat> findByTitle(String title);
}
