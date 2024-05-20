package ru.fafurin.orderservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.orderservice.domen.Order;
import ru.fafurin.orderservice.dto.OrderResponse;
import ru.fafurin.orderservice.dto.StatusResponse;
import ru.fafurin.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Tag(
        name = "Заказы",
        description = "Методы для работы с заказами"
)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    @Operation(summary = "Получить информацию обо всех заказах")
    public ResponseEntity<List<Order>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.getAll());
    }

    @PostMapping
    @Operation(summary = "Сохранить новый заказ")
    public ResponseEntity<Order> save(
            @RequestBody OrderResponse orderResponse) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.save(orderResponse));
    }

    @PostMapping("/change-status/{id}")
    @Operation(summary = "Изменить статус заказа")
    public ResponseEntity<Order> changeStatus(
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.setInWorkStatus(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить данные о заказе по идентификатору")
    public ResponseEntity<Order> updateOrder(
            @RequestBody @Valid OrderResponse orderResponse,
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        return ResponseEntity.ok(orderService.update(id, orderResponse));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить заказ по идентификатору")
    public ResponseEntity<String> deleteOrder(
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok(String.format("Order with id: %d deleted", id));
    }

}
