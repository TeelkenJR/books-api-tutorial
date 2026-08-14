package me.teelkenjr.databasespringboot.repositories;


import me.teelkenjr.databasespringboot.TestDataUtil;
import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;
import me.teelkenjr.databasespringboot.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {

    private final BookRepository underTest;


    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        AuthorEntity author = TestDataUtil.createTestAuthorA();
        BookEntity book = TestDataUtil.createTestBookA(author);
        underTest.save(book);
        System.out.println(author.getId());
        Optional<BookEntity> result = underTest.findById(book.getIsbn());
        author.setId(1L);
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }
}
