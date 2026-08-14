package me.teelkenjr.databasespringboot.repositories;


import me.teelkenjr.databasespringboot.TestDataUtil;
import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;
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
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;


    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        System.out.println(result.get());
        System.out.println(author);
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatGetAuthorsWithAgeLessThan() {
        AuthorEntity authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        AuthorEntity authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        AuthorEntity authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);

        Iterable<AuthorEntity> result = underTest.ageLessThan(50);
        assertThat(result).containsExactly(authorB, authorC);

        Iterable<AuthorEntity> result2 = underTest.ageIsExactlyGreaterThan(50);
        assertThat(result2).containsExactly(authorA);
    }
}
