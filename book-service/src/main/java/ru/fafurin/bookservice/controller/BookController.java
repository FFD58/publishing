package ru.fafurin.bookservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.bookservice.domen.Book;
import ru.fafurin.bookservice.dto.BookResponse;
import ru.fafurin.bookservice.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(
        name = "Книги",
        description = "Методы для работы с книгами"
)
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @Operation(summary = "Получить информацию обо всех заказчиках")
    public ResponseEntity<List<Book>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getAll());
    }

    @PostMapping
    @Operation(summary = "Сохранить новую книгу")
    public ResponseEntity<Book> save(
            @RequestBody BookResponse bookResponse) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.save(bookResponse));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить данные о книге по идентификатору")
    public ResponseEntity<Book> updateBook(
            @RequestBody @Valid BookResponse bookResponse,
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        return ResponseEntity.ok(bookService.update(id, bookResponse));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить книгу по идентификатору")
    public ResponseEntity<String> deleteBook(
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok(String.format("Book with id: %d deleted", id));
    }

}
