package ru.fafurin.taskservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Сотрудник")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    @Schema(description = "ФИО", example = "Иван Иванович Иванов")
    @Size(min = 3, max = 40)
    @NotBlank
    private String username;

    @Schema(description = "Пароль")
    @Size(min = 8)
    @NotBlank
    private String password;

    @Schema(description = "Пароль еще раз")
    @NotBlank
    private String matchingPassword;

    @Schema(description = "Email", example = "example@example.ru")
    @Email
    @NotBlank
    private String email;
}
