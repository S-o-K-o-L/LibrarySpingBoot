package com.example.library.domain.entity;

import jakarta.persistence.*;

@Table(name = "author_book")
@Entity
public class AuthorBook {
    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
