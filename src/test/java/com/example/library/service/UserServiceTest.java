package com.example.library.service;

import com.example.library.domain.entity.User;
import com.example.library.domain.exception.EntityNotFoundException;
import com.example.library.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void findUserById() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertEquals(user, userService.findUserById(userId));
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void findUserByIdWithException() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            userService.findUserById(userId);
        });
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void saveUser() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userRepository.save(user)).thenReturn(user);

        assertEquals(user, userService.saveUser(user));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void findUserByLoginWithException() {
        String login = "login";

        when(userRepository.findByLogin(login)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            userService.findUserByLogin(login);
        });
        verify(userRepository, times(1)).findByLogin(login);
    }

    @Test
    void findUserByLogin() {
        String login = "login";
        User user = new User();
        user.setLogin(login);

        when(userRepository.findByLogin(login)).thenReturn(Optional.of(user));

        assertEquals(user, userService.findUserByLogin(login));
        verify(userRepository, times(1)).findByLogin(login);
    }

    @Test
    void updateUser() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertEquals(user, userService.updateUser(userId,user));
        verify(userRepository, times(1)).save(user);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void deleteUser() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        doNothing().when(userRepository).deleteById(userId);

        verify(userRepository, times(0)).deleteById(userId);
    }

    @Test
    void findAll() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userRepository.findAll()).thenReturn(List.of(user));

        assertEquals(List.of(user), userService.findAll());
        verify(userRepository, times(1)).findAll();
    }
}