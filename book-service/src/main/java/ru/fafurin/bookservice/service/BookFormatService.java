package ru.fafurin.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fafurin.bookservice.domen.BookFormat;
import ru.fafurin.bookservice.dto.BookFormatResponse;
import ru.fafurin.bookservice.exception.BookFormatNotFoundException;
import ru.fafurin.bookservice.mapper.BookFormatMapper;
import ru.fafurin.bookservice.repository.BookFormatRepository;

import java.util.List;

@Service
public class BookFormatService {

    @Autowired
    private BookFormatRepository repository;

    public List<BookFormat> getAll() {
        return repository.findAll();
    }

    public BookFormat save(BookFormatResponse bookFormatResponse) {
        return repository.save(
                BookFormatMapper.getBookFormat(new BookFormat(), bookFormatResponse));
    }

    public BookFormat update(Integer id, BookFormatResponse bookFormatResponse) {
        BookFormat bookFormat = repository.findById(id)
                .orElseThrow(() -> new BookFormatNotFoundException(id));

        return repository.save(
                BookFormatMapper.getBookFormat(bookFormat, bookFormatResponse));
    }

    public void delete(Integer id) {
        BookFormat bookFormat = repository.findById(id)
                .orElseThrow(() -> new BookFormatNotFoundException(id));
        repository.delete(bookFormat);
    }
}
