package ru.fafurin.bookservice.mapper;

import ru.fafurin.bookservice.domen.BookType;
import ru.fafurin.bookservice.dto.BookTypeResponse;

public class BookTypeMapper {

    public static BookType getBookType(BookType bookType, BookTypeResponse bookTypeResponse) {
        bookType.setTitle(bookTypeResponse.getTitle());
        return bookType;
    }

}
