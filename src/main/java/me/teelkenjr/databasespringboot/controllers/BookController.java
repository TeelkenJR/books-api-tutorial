package me.teelkenjr.databasespringboot.controllers;


import me.teelkenjr.databasespringboot.domain.dto.BookDto;
import me.teelkenjr.databasespringboot.domain.entities.BookEntity;
import me.teelkenjr.databasespringboot.mappers.Mapper;
import me.teelkenjr.databasespringboot.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private Mapper<BookEntity, BookDto> bookMapper;
    private BookService bookService;

    public BookController(Mapper<BookEntity, BookDto> bookMapper, BookService bookService) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    /* under /books
    PUT /{isbn}
    GET /{isbn}
    GET /
    PUT /{isbn}
    PATCH /{isbn}
    DELETE /{isbn}
     */

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.CREATED);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<BookDto> findBook(@PathVariable("isbn") String isbn) {
        Optional<BookEntity> foundBook = bookService.findOne(isbn);
        return foundBook.map(
                entity -> new ResponseEntity<>(
                        bookMapper.mapTo(entity), HttpStatus.OK)
        ).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping("/books")
    public List<BookDto> findAll() {
        return bookService.findAll().stream()
                .map(bookEntity -> bookMapper.mapTo(bookEntity))
                .toList();
    }

}
