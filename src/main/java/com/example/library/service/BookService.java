package com.example.library.service;

import com.example.library.domain.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public interface BookService {
    Optional<Book> findBookById(Long id);
    Book saveBook(Book book);
    Optional<Book> findBookByName(String name);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    List<Book> findAll();
    Integer countReadUsers(Long id);
}
