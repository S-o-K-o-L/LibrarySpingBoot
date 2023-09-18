package com.example.library.service;

import com.example.library.domain.entity.Author;
import com.example.library.domain.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {
    Optional<Author> findAuthorById(Long id);
    Author saveAuthor(Author author);
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
    List<Author> findAll();
}
