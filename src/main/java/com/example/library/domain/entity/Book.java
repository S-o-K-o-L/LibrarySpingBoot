package com.example.library.domain.entity;

import com.example.library.domain.enums.Genre;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Collection;
import java.util.Set;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Type(StringArrayType.class)
    @Column(name = "genres", columnDefinition = "text[]")
    private Set<Genre> genres;

    @OneToMany(mappedBy = "book")
    private Set<Chapter> bookChapters;

    @OneToMany(mappedBy = "book")
    private Set<UserBook> userBooks;

    @OneToMany(mappedBy = "book")
    private Set<AuthorBook> authorBooks;
}
