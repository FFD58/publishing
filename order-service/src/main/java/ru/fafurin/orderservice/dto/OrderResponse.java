package ru.fafurin.orderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Заказ")
public class OrderResponse {
    @Schema(description = "Номер заказа",
            example = "1")
    private Integer number;

    @Schema(description = "Сроки",
            example = "Конец года")
    private String deadline;

    @Schema(description = "Описание",
            example = "Цветные рисунки")
    private String description;

    private CustomerResponse customerResponse;

}
