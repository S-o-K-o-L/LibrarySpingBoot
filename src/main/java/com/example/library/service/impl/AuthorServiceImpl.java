package com.example.library.service.impl;

import com.example.library.domain.entity.Author;

import com.example.library.repository.AuthorRepository;

import com.example.library.service.AuthorService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findAuthorById(Long id) {

        return authorRepository.findById(id);
    }
    @Override
    @Transactional
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public Author updateAuthor(Long id, Author author) {
        Author authorForUpdate = authorRepository.findById(id).orElse(new Author());
        authorForUpdate.setFirstName(author.getFirstName());
        authorForUpdate.setLastName(author.getLastName());
        authorForUpdate.setAuthorBooks(author.getAuthorBooks());
        return authorRepository.save(authorForUpdate);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }
}
