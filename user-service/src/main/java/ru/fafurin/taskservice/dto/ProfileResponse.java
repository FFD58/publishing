package ru.fafurin.taskservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Профиль сотрудника")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponse {

    @Schema(description = "Номер телефона", example = "81234567890")
    @NotBlank
    private String phone;

    @Schema(description = "Адрес", example = "г. Пенза, Красная, 40, 1")
    private String address;

    @Schema(description = "Дата трудоустройства", example = "01.01.2001")
    private String startedAt;

    @Schema(description = "Дата рождения", example = "01.01.2001")
    private String birthday;
}
