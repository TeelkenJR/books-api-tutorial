package me.teelkenjr.databasespringboot.repositories;

import me.teelkenjr.databasespringboot.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    Iterable<AuthorEntity> ageLessThan(int age);


    //this is not sql but hql
    @Query("SELECT a from AuthorEntity a WHERE a.age > ?1")
    Iterable<AuthorEntity> ageIsExactlyGreaterThan(int age);
}
