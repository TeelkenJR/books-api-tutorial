package me.teelkenjr.databasespringboot.services;

import me.teelkenjr.databasespringboot.domain.dto.BookDto;
import me.teelkenjr.databasespringboot.domain.entities.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);

    Optional<BookEntity> findOne(String isbn);

    List<BookEntity> findAll();
}
