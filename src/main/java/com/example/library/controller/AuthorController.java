package com.example.library.controller;

import com.example.library.domain.entity.Author;
import com.example.library.service.AuthorService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
@CacheConfig(cacheNames = "authorCache")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @Cacheable
    public List<Author> findAllAuthor() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable
    public Optional<Author> findAuthorById(@PathVariable("id") Long id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping
    @Cacheable(key = "#author.lastName")
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    @CachePut(key = "#author.lastName")
    public Author updateAuthor(@RequestBody Author author, @PathVariable Long id) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    @CacheEvict
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }
}
