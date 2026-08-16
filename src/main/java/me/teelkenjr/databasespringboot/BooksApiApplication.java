package me.teelkenjr.databasespringboot;

import lombok.extern.java.Log;
import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class BooksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApiApplication.class, args);
    }

}
