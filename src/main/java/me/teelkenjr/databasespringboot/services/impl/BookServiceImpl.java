package me.teelkenjr.databasespringboot.services.impl;

import me.teelkenjr.databasespringboot.domain.dto.BookDto;
import me.teelkenjr.databasespringboot.domain.entities.BookEntity;
import me.teelkenjr.databasespringboot.repositories.BookRepository;
import me.teelkenjr.databasespringboot.services.BookService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }

    @Override
    public Optional<BookEntity> findOne(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).toList();
    }
}
