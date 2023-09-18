package com.example.library.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "author")
    private List<AuthorBook> authorBooks;
}
