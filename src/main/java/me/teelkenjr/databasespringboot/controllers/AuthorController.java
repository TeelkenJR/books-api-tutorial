package me.teelkenjr.databasespringboot.controllers;

import me.teelkenjr.databasespringboot.domain.dto.AuthorDto;
import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;
import me.teelkenjr.databasespringboot.mappers.Mapper;
import me.teelkenjr.databasespringboot.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {


    private AuthorService authorService;
    private Mapper<AuthorEntity, AuthorDto> authorMapper;



    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }


    @PostMapping("/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedauthorEntity = authorService.createAuthor(authorEntity);

        return new ResponseEntity<>(authorMapper.mapTo(savedauthorEntity), HttpStatus.CREATED);
    }

    @GetMapping("/authors")
    public List<AuthorDto> listAuthors() {
        List<AuthorEntity> authors = authorService.findAll();
        return authors.stream()
                .map(authorMapper::mapTo)
                .toList();
    }
}
