package com.example.library.service;

import com.example.library.domain.entity.Book;
import com.example.library.domain.entity.User;
import com.example.library.domain.entity.UserBook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface UserService {
    User findUserById(Long id);
    User saveUser(User user);
    User findUserByLogin(String name);
    User updateUser(Long id, User user);

    Set<UserBook> getUserBooks(Long id);
    void deleteUser(Long id);
    List<User> findAll();
}
