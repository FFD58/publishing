package ru.fafurin.taskservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.taskservice.domen.User;
import ru.fafurin.taskservice.dto.UserResponse;
import ru.fafurin.taskservice.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(
        name = "Сотрудники",
        description = "Методы для работы с сотрудниками"
)
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Получить информацию обо всех сотрудниках")
    public ResponseEntity<List<User>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAll());
    }

    @PostMapping
    @Operation(summary = "Сохранить нового сотрудника")
    public ResponseEntity<User> save(
            @RequestBody @Valid UserResponse userResponse) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.save(userResponse));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить данные о сотрудника по идентификатору")
    public ResponseEntity<User> updateUser(
            @RequestBody @Valid UserResponse userResponse,
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(id, userResponse));
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Удалить сотрудника по идентификатору")
//    public ResponseEntity<String> deleteUser(
//            @Parameter(description = "Идентификатор") @PathVariable Long id) {
//        userService.delete(id);
//        return ResponseEntity.ok(String.format("User with id: %d deleted", id));
//    }

}
