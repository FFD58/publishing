package ru.fafurin.bookservice.mapper;

import ru.fafurin.bookservice.domen.Book;
import ru.fafurin.bookservice.domen.BookFile;
import ru.fafurin.bookservice.dto.BookFileResponse;
import ru.fafurin.bookservice.dto.BookResponse;

import java.util.List;

public class BookMapper {

    public static Book getBook(Book book, BookResponse bookResponse) {
        book.setTitle(bookResponse.getTitle());
        book.setAuthors(bookResponse.getAuthors());

        if (bookResponse.getFiles().size() != 0) {
            List<BookFileResponse> fileResponses = bookResponse.getFiles();
            List<BookFile> files = fileResponses.stream().map(f -> BookFileMapper.getBookFile(new BookFile(), f)).toList();
            book.setFiles(files);
        }
        return book;
    }
}
