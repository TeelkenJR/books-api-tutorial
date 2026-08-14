package me.teelkenjr.databasespringboot.services;

import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {

    AuthorEntity createAuthor(AuthorEntity author);

    List<AuthorEntity> findAll();
}
