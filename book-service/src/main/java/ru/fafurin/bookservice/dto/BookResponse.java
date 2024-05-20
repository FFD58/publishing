package ru.fafurin.bookservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Книга")
public class BookResponse {
    @Schema(description = "Название",
            example = "Война и мир")
    @Size(min = 3, max = 50)
    @NotBlank
    private String title;
    private Integer bookTypeId;
    private Integer bookFormatId;
    private List<String> authors;
    private List<BookFileResponse> files;

}
