package ru.fafurin.taskservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.fafurin.taskservice.domen.Status;

@Data
@Schema(description = "Статус")
public class StatusResponse {
    @Schema(description = "Номер заказа",
            example = "1")
    private Long orderId;

    @Schema(description = "Статус",
            example = "IN_WORK")
    private Status status;

}
