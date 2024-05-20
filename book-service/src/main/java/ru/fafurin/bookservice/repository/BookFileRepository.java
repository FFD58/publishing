package ru.fafurin.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fafurin.bookservice.domen.BookFile;

public interface BookFileRepository extends JpaRepository<BookFile, Long> {
}
