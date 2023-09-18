package com.example.library.service.impl;

import com.example.library.controller.BookController;
import com.example.library.domain.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }
    @Override
    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

    @Override
    @Transactional
    public Book updateBook(Long id, Book book) {
        Book bookForUpdate = bookRepository.findById(id).orElse(new Book());
        bookForUpdate.setName(book.getName());
        bookForUpdate.setDescription(book.getDescription());
        bookForUpdate.setGenres(book.getGenres());
        bookForUpdate.setUserBooks(book.getUserBooks());
        bookForUpdate.setBookChapters(book.getBookChapters());
        return bookRepository.save(bookForUpdate);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countReadUsers(Long id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        return book.getUserBooks().size();
    }
}
