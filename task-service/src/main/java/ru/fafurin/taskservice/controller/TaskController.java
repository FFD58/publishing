package ru.fafurin.taskservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.taskservice.domen.UserTask;
import ru.fafurin.taskservice.dto.UserTaskResponse;
import ru.fafurin.taskservice.service.UserTaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
@Tag(
        name = "Задачи сотрудников",
        description = "Методы для работы с задачами"
)
public class TaskController {

    private final UserTaskService userTaskService;

    @GetMapping
    @Operation(summary = "Получить информацию обо всех задачах")
    public ResponseEntity<List<UserTask>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userTaskService.getAll());
    }

    @PostMapping
    @Operation(summary = "Сохранить нового сотрудника")
    public ResponseEntity<UserTask> save(
            @RequestBody @Valid UserTaskResponse userTaskResponse) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userTaskService.save(userTaskResponse));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить данные о сотрудника по идентификатору")
    public ResponseEntity<UserTask> updateUserTask(
            @RequestBody @Valid UserTaskResponse userTaskResponse,
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        return ResponseEntity.ok(userTaskService.update(id, userTaskResponse));
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Удалить сотрудника по идентификатору")
//    public ResponseEntity<String> deleteUserTask(
//            @Parameter(description = "Идентификатор") @PathVariable Long id) {
//        userTaskService.delete(id);
//        return ResponseEntity.ok(String.format("UserTask with id: %d deleted", id));
//    }

}
