package ru.fafurin.bookservice.mapper;

import ru.fafurin.bookservice.domen.BookFile;
import ru.fafurin.bookservice.dto.BookFileResponse;

public class BookFileMapper {

    public static BookFile getBookFile(BookFile bookFile, BookFileResponse bookFileResponse) {
        bookFile.setPath(bookFileResponse.getPath());
        return bookFile;
    }

}
