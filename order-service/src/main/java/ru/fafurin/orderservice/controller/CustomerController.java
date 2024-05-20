package ru.fafurin.orderservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.orderservice.domen.Customer;
import ru.fafurin.orderservice.dto.CustomerResponse;
import ru.fafurin.orderservice.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(
        name = "Заказчики",
        description = "Методы для работы с заказчиками"
)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @Operation(summary = "Получить информацию обо всех заказчиках")
    public ResponseEntity<List<Customer>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.getAll());
    }

    @PostMapping
    @Operation(summary = "Сохранить нового заказчика")
    public ResponseEntity<Customer> save(
            @RequestBody CustomerResponse customerResponse) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.save(customerResponse));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить данные о заказчике по идентификатору")
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody @Valid CustomerResponse customerResponse,
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        return ResponseEntity.ok(customerService.update(id, customerResponse));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить заказчика по идентификатору")
    public ResponseEntity<String> deleteCustomer(
            @Parameter(description = "Идентификатор") @PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok(String.format("Customer with id: %d deleted", id));
    }

}
