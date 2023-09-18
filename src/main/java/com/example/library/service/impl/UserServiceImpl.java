package com.example.library.service.impl;

import com.example.library.domain.entity.User;
import com.example.library.domain.entity.UserBook;
import com.example.library.domain.exception.EntityNotFoundException;
import com.example.library.repository.UserRepository;
import com.example.library.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        log.info("Поиск пользоваетля по id " + id);
        return userRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Пользователь с id " + id + " не найден");
                    throw new EntityNotFoundException("User not found");
                });
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByLogin(String name) {
        return userRepository.findByLogin(name).orElseThrow(
                () -> {
                    log.error("Пользователь с логином " + name + " не найден");
                    throw new EntityNotFoundException("User not found");
                });
    }

    @Override
    @Transactional
    public User updateUser(Long id, User user) {
        User userForUpdate = userRepository.findById(id).orElse(new User());
        userForUpdate.setLogin(user.getLogin());
        userForUpdate.setPassword(user.getPassword());
        userForUpdate.setRole(user.getRole());
        userForUpdate.setFirstName(user.getFirstName());
        userForUpdate.setLastName(user.getLastName());
        userForUpdate.setTelephoneNumber(user.getTelephoneNumber());
        userForUpdate.setUserBook(user.getUserBook());
        return userRepository.save(userForUpdate);
    }

    @Override
    @Transactional
    public Set<UserBook> getUserBooks(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return user.getUserBook();
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
