package ru.fafurin.bookservice.mapper;

import ru.fafurin.bookservice.domen.BookFormat;
import ru.fafurin.bookservice.dto.BookFormatResponse;

public class BookFormatMapper {

    public static BookFormat getBookFormat(BookFormat bookFormat, BookFormatResponse bookFormatResponse) {
        bookFormat.setTitle(bookFormatResponse.getTitle());
        bookFormat.setDesignation(bookFormatResponse.getDesignation());
        return bookFormat;
    }


}
