package ru.fafurin.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseTmp {

    private Long id;
    private String bookTitle;
    private String bookFormat;
    private Integer number;

}
