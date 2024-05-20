package ru.fafurin.bookservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Книжный формат")
public class BookTypeResponse {
    @Schema(description = "Название", example = "Монография")
    @Size(min = 3, max = 30)
    @NotBlank
    private String title;
}
