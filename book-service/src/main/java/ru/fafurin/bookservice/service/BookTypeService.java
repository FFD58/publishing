package ru.fafurin.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fafurin.bookservice.domen.BookType;
import ru.fafurin.bookservice.dto.BookTypeResponse;
import ru.fafurin.bookservice.exception.BookTypeNotFoundException;
import ru.fafurin.bookservice.mapper.BookTypeMapper;
import ru.fafurin.bookservice.repository.BookTypeRepository;

import java.util.List;

@Service
public class BookTypeService {

    @Autowired
    private BookTypeRepository repository;

    public List<BookType> getAll() {
        return repository.findAll();
    }

    public BookType save(BookTypeResponse bookTypeResponse) {
        return repository.save(
                BookTypeMapper.getBookType(new BookType(), bookTypeResponse));
    }

    public BookType update(Integer id, BookTypeResponse bookTypeResponse) {
        BookType bookType = repository.findById(id)
                .orElseThrow(() -> new BookTypeNotFoundException(id));

        return repository.save(
                BookTypeMapper.getBookType(bookType, bookTypeResponse));
    }

    public void delete(Integer id) {
        BookType bookType = repository.findById(id)
                .orElseThrow(() -> new BookTypeNotFoundException(id));
        repository.delete(bookType);
    }
}
