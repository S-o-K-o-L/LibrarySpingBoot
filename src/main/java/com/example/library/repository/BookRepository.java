package com.example.library.repository;

import com.example.library.domain.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findBookByName(String name);

    @Query(nativeQuery = true,
        value = "SELECT book.id, book.name, book.description, book.genres" +
                " FROM book WHERE book.name % ?1")
    List<Book> fuzzySearchBookByName(String name);
}
