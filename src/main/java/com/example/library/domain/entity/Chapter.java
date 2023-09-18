package com.example.library.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"number", "book_id"})})
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String content;

    private Integer number;

    @ManyToOne()
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
