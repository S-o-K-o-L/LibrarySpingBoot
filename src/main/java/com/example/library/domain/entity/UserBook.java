package com.example.library.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;


@Table(name = "user_book")
@Entity
public class UserBook {
    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
