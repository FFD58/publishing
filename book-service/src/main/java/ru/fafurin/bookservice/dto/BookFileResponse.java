package ru.fafurin.bookservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Файл")
public class BookFileResponse {
    @Schema(description = "Путь к файлу")
    private String path;
}
