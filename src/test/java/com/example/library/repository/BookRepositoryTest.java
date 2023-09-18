package com.example.library.repository;

import com.example.library.domain.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    private final BookRepository bookRepository;

    @Autowired
    BookRepositoryTest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    void findBookByName() {
        String name = "Popula";
        Book book = bookRepository.findBookByName(name).orElse(new Book());
        assertNotEquals(name,book.getName());
    }

    @Test
    void fuzzySearchBookByName() {
        String name = "Papula43";
        List<Book> books = bookRepository.fuzzySearchBookByName(name);
        assertEquals("Popula43",books.get(0).getName());
    }
}