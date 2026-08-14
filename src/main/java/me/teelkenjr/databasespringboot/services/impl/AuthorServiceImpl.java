package me.teelkenjr.databasespringboot.services.impl;

import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;
import me.teelkenjr.databasespringboot.repositories.AuthorRepository;
import me.teelkenjr.databasespringboot.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl  implements AuthorService {


    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorEntity createAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(authorRepository.findAll().spliterator(), false).toList();
    }
}
