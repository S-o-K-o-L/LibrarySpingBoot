package com.example.library.controller;

import com.example.library.domain.entity.Book;
import com.example.library.service.BookService;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@CacheConfig(cacheNames = "bookCache")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping("/{id}")
    @Cacheable
    public Optional<Book> findBookById(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }



    @PostMapping
    @Cacheable(key = "#book.name")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    @CachePut(key = "#book.name")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.updateBook(id, book);
    }

    @GetMapping()
    @CachePut(key = "#book.name")
    public List<String> fuzzySearch(@RequestBody Book string) {
        return bookService.fuzzySearchByName(string);
    }
    @DeleteMapping("/{id}")
    @CacheEvict
    public void deleteBook(@PathVariable("id") Long id) {
         bookService.deleteBook(id);
    }
}
