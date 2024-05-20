package ru.fafurin.bookservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Книжный формат")
public class BookFormatResponse {
    @Schema(description = "Название", example = "А4")
    @Size(min = 2, max = 30)
    @NotBlank
    private String title;
    @Schema(description = "Размер", example = "60х84/8")
    private String designation;
}
