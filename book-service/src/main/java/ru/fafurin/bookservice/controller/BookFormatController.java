package ru.fafurin.bookservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.bookservice.domen.BookFormat;
import ru.fafurin.bookservice.dto.BookFormatResponse;
import ru.fafurin.bookservice.service.BookFormatService;

import java.util.List;

@RestController
@RequestMapping("/api/books/formats")
@Tag(
        name = "Форматы книг",
        description = "Методы для работы с книжными форматами"
)
public class BookFormatController {

    @Autowired
    private BookFormatService bookFormatService;

    @GetMapping
    @Operation(summary = "Получить информацию обо всех книжных форматах")
    public ResponseEntity<List<BookFormat>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookFormatService.getAll());
    }

    @PostMapping
    @Operation(summary = "Сохранить новый книжный формат")
    public ResponseEntity<BookFormat> save(
            @RequestBody BookFormatResponse bookFormatResponse) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookFormatService.save(bookFormatResponse));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить книжный формат по идентификатору")
    public ResponseEntity<BookFormat> updateBookFormat(
            @RequestBody @Valid BookFormatResponse bookFormatResponse,
            @Parameter(description = "Идентификатор") @PathVariable Integer id) {
        return ResponseEntity.ok(bookFormatService.update(id, bookFormatResponse));
    }

    @DeleteMapping ("/{id}")
    @Operation(summary = "Удалить книжный формат по идентификатору")
    public ResponseEntity<String> deleteBookFormat(
            @Parameter(description = "Идентификатор") @PathVariable Integer id) {
        bookFormatService.delete(id);
        return ResponseEntity.ok(String.format("Book format with id: %d deleted", id));
    }

}
