package ru.fafurin.bookservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.bookservice.domen.BookType;
import ru.fafurin.bookservice.dto.BookTypeResponse;
import ru.fafurin.bookservice.service.BookTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/books/types")
@Tag(
        name = "Типы книг",
        description = "Методы для работы с типами книг"
)
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    @GetMapping
    @Operation(summary = "Получить информацию обо всех типах книг")
    public ResponseEntity<List<BookType>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookTypeService.getAll());
    }

    @PostMapping
    @Operation(summary = "Сохранить новый тип книги")
    public ResponseEntity<BookType> save(
            @RequestBody BookTypeResponse bookTypeResponse) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookTypeService.save(bookTypeResponse));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить тип книги по идентификатору")
    public ResponseEntity<BookType> updateBookType(
            @RequestBody @Valid BookTypeResponse bookTypeResponse,
            @Parameter(description = "Идентификатор") @PathVariable Integer id) {
        return ResponseEntity.ok(bookTypeService.update(id, bookTypeResponse));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить тип книги по идентификатору")
    public ResponseEntity<String> deleteBookType(
            @Parameter(description = "Идентификатор") @PathVariable Integer id) {
        bookTypeService.delete(id);
        return ResponseEntity.ok(String.format("Book type with id: %d deleted", id));
    }

}
