package me.teelkenjr.databasespringboot.services;

import me.teelkenjr.databasespringboot.domain.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookEntity save(String isbn, BookEntity book);

    Optional<BookEntity> findOne(String isbn);

    List<BookEntity> findAll();

    Page<BookEntity> findAll(Pageable pageable);

    boolean exists(String isbn);

    BookEntity partialUpdate(String isbn, BookEntity bookEntity);

    void delete(String isbn);
}
