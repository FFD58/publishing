package ru.fafurin.taskservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Задача")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTaskResponse {
    @Schema(description = "Название", example = "0 верстка")
    @Size(min = 3, max = 40)
    @NotBlank
    private String title;

    @Schema(description = "Идентификатор заказа")
    private Long orderId;

    @Schema(description = "Идентификатор сотрудника")
    private Long userId;
}
