package me.teelkenjr.databasespringboot;

import me.teelkenjr.databasespringboot.domain.dto.AuthorDto;
import me.teelkenjr.databasespringboot.domain.dto.BookDto;
import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;
import me.teelkenjr.databasespringboot.domain.entities.BookEntity;

public class TestDataUtil {
    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .name("Dorthy Mckenzie")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .name("John Johnson")
                .age(40)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .name("Katy Westwood")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookA(AuthorEntity author) {
        return BookEntity.builder()
                .isbn("97547-575965425-751954")
                .title("The Enshitification of the Internet")
                .author(author)
                .build();
    }

    public static BookDto createTestBookDtoA(AuthorDto author) {
        return BookDto.builder()
                .isbn("97547-575965425-751954")
                .title("The Enshitification of the Internet")
                .author(author)
                .build();
    }
}
