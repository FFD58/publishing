package ru.fafurin.orderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Заказчик")
public class CustomerResponse {
    @Schema(description = "ФИО или название фирмы или подразделения",
            example = "Иван Иванович Иванов")
    @Size(min = 3, max = 40)
    @NotBlank
    private String name;

    @Schema(description = "Адрес электронной почты",
            example = "example@example.ru")
    @Email
    private String email;

    @Schema(description = "Телефон (мобильный или городской)",
            example = "81234567890")
    @NotBlank
    private String phone;
}
