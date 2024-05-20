package ru.fafurin.bookservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fafurin.bookservice.domen.Book;
import ru.fafurin.bookservice.domen.BookFormat;
import ru.fafurin.bookservice.domen.BookType;
import ru.fafurin.bookservice.dto.BookResponse;
import ru.fafurin.bookservice.exception.BookFormatNotFoundException;
import ru.fafurin.bookservice.exception.BookNotFoundException;
import ru.fafurin.bookservice.exception.BookTypeNotFoundException;
import ru.fafurin.bookservice.mapper.BookMapper;
import ru.fafurin.bookservice.repository.BookFormatRepository;
import ru.fafurin.bookservice.repository.BookRepository;
import ru.fafurin.bookservice.repository.BookTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookFormatRepository bookFormatRepository;
    private final BookTypeRepository bookTypeRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book save(BookResponse bookResponse) {

        Book book = new Book();

        Integer typeId = bookResponse.getBookTypeId();

        BookType bookType = bookTypeRepository.findById(typeId)
                .orElseThrow(() -> new BookTypeNotFoundException(typeId));
        book.setType(bookType);

        Integer formatId = bookResponse.getBookFormatId();

        BookFormat bookFormat = bookFormatRepository.findById(formatId)
                .orElseThrow(() -> new BookFormatNotFoundException(formatId));
        book.setFormat(bookFormat);

        return bookRepository.save(BookMapper.getBook(book, bookResponse));
    }

    public Book update(Long id, BookResponse bookResponse) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookRepository.save(
                BookMapper.getBook(book, bookResponse));
    }

    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(book);
    }
}
